package pe.edu.upeu.sysventas.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.service.IVentaService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@Service
public class WhatsAppSenderService {

    private final IVentaService ventaService;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${whatsapp.access-token}")
    private String accessToken;

    @Value("${whatsapp.phone-number-id}")
    private String phoneNumberId;

    public WhatsAppSenderService(IVentaService ventaService) {
        this.ventaService = ventaService;
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Genera el PDF de la boleta usando tu runReport(...) y lo envía por WhatsApp Cloud API (Meta).
     * recipientPhone debe incluir el código de país (ej: 519XXXXXXXX para Perú).
     */
    public void sendBoletaWhatsApp(Long idVenta, String recipientPhone) throws JRException, SQLException, IOException {
        // 1) Generar JasperPrint y exportar a PDF bytes
        JasperPrint jasperPrint = ventaService.runReport(idVenta);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        // 2) Subir media (multipart/form-data) para obtener media_id
        String uploadUrl = "https://graph.facebook.com/v17.0/" + phoneNumberId + "/media";
        RequestBody fileBody = RequestBody.create(pdfBytes, MediaType.parse("application/pdf"));
        MultipartBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "boleta_" + idVenta + ".pdf", fileBody)
                .build();

        Request uploadRequest = new Request.Builder()
                .url(uploadUrl)
                .addHeader("Authorization", "Bearer " + accessToken)
                .post(requestBody)
                .build();

        try (Response uploadResp = httpClient.newCall(uploadRequest).execute()) {
            if (!uploadResp.isSuccessful() || uploadResp.body() == null) {
                throw new IOException("Fallo al subir media: " + (uploadResp.body() != null ? uploadResp.body().string() : uploadResp));
            }
            String uploadRespStr = Objects.requireNonNull(uploadResp.body()).string();
            JsonNode uploadJson = objectMapper.readTree(uploadRespStr);
            if (!uploadJson.has("id")) {
                throw new IOException("Respuesta inesperada al subir media: " + uploadRespStr);
            }
            String mediaId = uploadJson.get("id").asText();

            // 3) Enviar mensaje tipo document usando media_id
            String sendUrl = "https://graph.facebook.com/v17.0/" + phoneNumberId + "/messages";
            // Construir JSON
            JsonNode root = objectMapper.createObjectNode()
                    .put("messaging_product", "whatsapp")
                    .put("to", recipientPhone)
                    .put("type", "document");
            JsonNode documentNode = objectMapper.createObjectNode()
                    .put("id", mediaId)
                    .put("filename", "boleta_" + idVenta + ".pdf");
            ((com.fasterxml.jackson.databind.node.ObjectNode) root).set("document", documentNode);

            RequestBody sendBody = RequestBody.create(objectMapper.writeValueAsBytes(root), MediaType.parse("application/json"));
            Request sendRequest = new Request.Builder()
                    .url(sendUrl)
                    .addHeader("Authorization", "Bearer " + accessToken)
                    .post(sendBody)
                    .build();

            try (Response sendResp = httpClient.newCall(sendRequest).execute()) {
                if (!sendResp.isSuccessful() || sendResp.body() == null) {
                    throw new IOException("Fallo al enviar mensaje: " + (sendResp.body() != null ? sendResp.body().string() : sendResp));
                }
                // OK: se puede loggear la respuesta si quieres
            }
        }
    }
}
