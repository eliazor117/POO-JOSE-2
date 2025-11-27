package pe.edu.upeu.sysventas.controller;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Helper para exportar JasperPrint a PDF, protegerlo y enviarlo por WhatsApp Cloud API.
 */
public class WhatsAppSender {

    public static Path exportAndProtectPdf(JasperPrint jasperPrint, Long idVenta, String ownerPassword) throws Exception {
        String dir = "boletas";
        new File(dir).mkdirs();
        String tempPdf = dir + File.separator + "boleta_" + idVenta + ".pdf";
        String lockedPdf = dir + File.separator + "boleta_" + idVenta + "_locked.pdf";

        // Exportar a PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, tempPdf);

        // Proteger PDF (owner password) permitiendo impresión pero sin edición
        PdfReader reader = new PdfReader(tempPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(lockedPdf));
        stamper.setEncryption(
                null,
                ownerPassword.getBytes(),
                PdfWriter.ALLOW_PRINTING,
                PdfWriter.ENCRYPTION_AES_128
        );
        stamper.close();
        reader.close();

        return Paths.get(lockedPdf);
    }

    public static String uploadMediaToWhatsApp(String token, String phoneNumberId, Path filePath) throws Exception {
        String url = "https://graph.facebook.com/v17.0/" + phoneNumberId + "/media?access_token=" + token;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        FileBody fileBody = new FileBody(filePath.toFile(), ContentType.create("application/pdf"));
        HttpEntity entity = MultipartEntityBuilder.create()
                .addPart("file", fileBody)
                .addTextBody("messaging_product", "whatsapp")
                .build();
        post.setEntity(entity);

        CloseableHttpResponse response = client.execute(post);
        String body = EntityUtils.toString(response.getEntity(), "UTF-8");
        response.close();
        client.close();

        JSONObject json = new JSONObject(body);
        return json.getString("id");
    }

    public static void sendDocumentMessage(String token, String phoneNumberId, String toPhone, String mediaId, String filename) throws Exception {
        String url = "https://graph.facebook.com/v17.0/" + phoneNumberId + "/messages?access_token=" + token;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        JSONObject payload = new JSONObject();
        payload.put("messaging_product", "whatsapp");
        payload.put("to", toPhone);
        payload.put("type", "document");

        JSONObject doc = new JSONObject();
        doc.put("id", mediaId);
        doc.put("filename", filename);

        payload.put("document", doc);

        StringEntity se = new StringEntity(payload.toString(), ContentType.APPLICATION_JSON);
        post.setEntity(se);

        CloseableHttpResponse response = client.execute(post);
        String body = EntityUtils.toString(response.getEntity(), "UTF-8");
        response.close();
        client.close();

        System.out.println("WhatsApp send response: " + body);
    }

    public static void sendBoletaByWhatsApp(JasperPrint jasperPrint, Long idVenta, String clientePhone) throws Exception {
        String token = System.getenv("WHATSAPP_ACCESS_TOKEN");
        String phoneNumberId = System.getenv("WHATSAPP_PHONE_NUMBER_ID");
        String ownerPassword = System.getenv().getOrDefault("BOLETA_OWNER_PWD", "miPassSegura");

        if (token == null || phoneNumberId == null) {
            throw new IllegalStateException("Configura WHATSAPP_ACCESS_TOKEN y WHATSAPP_PHONE_NUMBER_ID en variables de entorno.");
        }

        Path lockedPdf = exportAndProtectPdf(jasperPrint, idVenta, ownerPassword);
        String mediaId = uploadMediaToWhatsApp(token, phoneNumberId, lockedPdf);
        sendDocumentMessage(token, phoneNumberId, clientePhone, mediaId, lockedPdf.getFileName().toString());
    }
}