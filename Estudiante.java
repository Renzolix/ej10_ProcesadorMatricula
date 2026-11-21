public class Estudiante {
    private String legajo;

    public Estudiante(String legajo) {
        if (legajo == null || legajo.trim().isEmpty() || !legajo.startsWith("E")) {
            throw new LegajoInvalidoException("El legajo debe ser no nulo, no vacío y comenzar con 'E'. Formato recibido: " + legajo);
        }
        this.legajo = legajo;
    }

    public String getLegajo() {
        return legajo;
    }

    public static void main(String[] args) {
        System.out.println("Instanciando estudiante válido...");
        Estudiante e1 = new Estudiante("E-4592");
        System.out.println("Legajo: " + e1.getLegajo());

        System.out.println("\nIntentando instanciar estudiante con legajo inválido ('12345')...");
        try {
            Estudiante e2 = new Estudiante("12345");
        } catch (LegajoInvalidoException e) {
            System.err.println("Excepción Runtime capturada: " + e.getMessage());
        }
    }
}