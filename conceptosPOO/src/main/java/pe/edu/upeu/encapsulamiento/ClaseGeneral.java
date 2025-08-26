package pe.edu.upeu.encapsulamiento;

public class ClaseGeneral {
    public static void main(String[] args) {
        Persona p = new Persona(); // p=objeto
        //p.nombre = "David";
        //p.edad = 25;
        p.setNombre("Jose"); //encapsulamiento
        p.setEdad(25);//privado
        p.apellido = "Aroapaza";//no se esta aplicando encapsulamiento
        p.saluda();

        Trabajador t = new Trabajador();
        t.setNombre("Jose");
        t.setApellido("Aroapaza");
        t.setEdad(25);
        t.setArea("sistemas");
        t.setGenero('M');
        System.out.println(t);
    }
}
