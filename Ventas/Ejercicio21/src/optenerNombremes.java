public class optenerNombremes {

    public static String obtenerNombreMes(int mes) {
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        if (mes < 1 || mes > 12) {
            return "Mes inválido";
        }
        return meses[mes - 1];
    }

    public static void main(String[] args) {
        int año = 2025;
        int mes = 11;

        System.out.println("Año: " + año);
        System.out.println("Mes: " + obtenerNombreMes(mes));
    }
}
