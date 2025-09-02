package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum TipoParticipante {
    ASISTENTE("asistente"),
    AORGANIZADOR("aorganizador"),
    PONENTE("ponente"),;

    private String descripcion;
}
