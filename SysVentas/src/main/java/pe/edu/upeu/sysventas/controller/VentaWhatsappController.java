package pe.edu.upeu.sysventas.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysventas.service.impl.WhatsAppSenderService;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/ventas")
public class VentaWhatsappController {

    private final WhatsAppSenderService whatsAppSenderService;

    public VentaWhatsappController(WhatsAppSenderService whatsAppSenderService) {
        this.whatsAppSenderService = whatsAppSenderService;
    }

    /**
     * POST /ventas/{id}/send-whatsapp?phone=519XXXXXXXX
     * No modifica ningún archivo existente: solo llama a tu runReport(...) a través de IVentaService.
     */
    @PostMapping("/{id}/send-whatsapp")
    public ResponseEntity<?> sendWhatsApp(@PathVariable Long id, @RequestParam("phone") String phone) {
        try {
            whatsAppSenderService.sendBoletaWhatsApp(id, phone);
            return ResponseEntity.ok(Map.of("status", "enviado"));
        } catch (JRException | SQLException e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error generando la boleta: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error enviando por WhatsApp: " + e.getMessage()));
        }
    }
}