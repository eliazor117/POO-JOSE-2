import java.util.*;
class RedDeAmigos {
    private Map<String, Set<String>> grafo;

    public RedDeAmigos() {
        grafo = new HashMap<>();
    }
    public void agregarPersona(String nombre) {
        grafo.putIfAbsent(nombre, new HashSet<>());
    }
    public void agregarAmistad(String persona1, String persona2) {
        if (!grafo.containsKey(persona1) || !grafo.containsKey(persona2)) {
            System.out.println("Error: una de las personas no está registrada.");
            return;
        }
        grafo.get(persona1).add(persona2);
        grafo.get(persona2).add(persona1);
    }
    public void mostrarAmigos(String persona) {
        if (!grafo.containsKey(persona)) {
            System.out.println(persona + " no está en la red.");
            return;
        }
        Set<String> amigos = grafo.get(persona);
        System.out.println(persona + " tiene " + amigos.size() + " amigos: " + amigos);
    }
    public void mostrarRedCompleta() {
        System.out.println("Red de Amigos Completa:");
        for (String persona : grafo.keySet()) {
            System.out.println("- " + persona + " -> " + grafo.get(persona));
        }
    }

    public static void main(String[] args) {
        RedDeAmigos red = new RedDeAmigos();

        red.agregarPersona("Jose");
        red.agregarPersona("Patrick");
        red.agregarPersona("Bryans");
        red.agregarPersona("Kenny");
        red.agregarPersona("Eduardo");

        red.agregarAmistad("Jose", "Patrick");
        red.agregarAmistad("Kenny", "Eduardo");
        red.agregarAmistad("Jose", "Bryans");
        red.agregarAmistad("Eduardo", "Patrick");

        System.out.println();
        red.mostrarRedCompleta();

        System.out.println();
        red.mostrarAmigos("Jose");
        red.mostrarAmigos("Eduardo");
    }
}
