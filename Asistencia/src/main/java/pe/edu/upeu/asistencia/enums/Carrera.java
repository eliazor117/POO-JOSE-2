package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum Carrera {
    SISTEMAS(Facultad.FIA,"Ing. de Sistemas"),
    CIVIL(Facultad.FIA,"Ing. Civil"),
    AMVIENTAL(Facultad.FIA,"Ing. Amviental"),


    ADMINISTRACION(Facultad.FCE,"Administracion"),
    NUTRICION(Facultad.FACIHED,"Nutricion"),
    EDUCACION(Facultad.GENERAL,"Educacion"),
    ;

    private Facultad facultad;
    private String descripcion;

}
