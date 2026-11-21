public class ProcesadorMatricula {

    public boolean confirmarMatricula(Estudiante e, boolean documentacionAlDia, boolean arancelAlDia) throws PagoMatriculaPendienteException {
        if (e == null || !documentacionAlDia) {
            throw new DocumentacionIncompletaException("La documentación obligatoria del estudiante no está completa.");
        }
        if (!arancelAlDia) {
            throw new PagoMatriculaPendienteException("El arancel de matrícula registra un saldo pendiente.");
        }

        System.out.println("Matrícula confirmada para el estudiante legajo: " + e.getLegajo());
        return true;
    }

    public static void main(String[] args) {
        ProcesadorMatricula procesador = new ProcesadorMatricula();
        Estudiante alumno = new Estudiante("E-500");

        System.out.println("--- Caso 1: Documentación Incompleta ---");
        try {
            procesador.confirmarMatricula(alumno, false, true);
        } catch (PagoMatriculaPendienteException e) {
            System.err.println("Error de Pago: " + e.getMessage());
        } catch (DocumentacionIncompletaException e) {
            System.err.println("Error Documental (Runtime): " + e.getMessage());
        } finally {
            System.out.println("Registro de auditoría de matriculación cerrado.\n");
        }

        System.out.println("--- Caso 2: Pago Pendiente ---");
        try {
            procesador.confirmarMatricula(alumno, true, false);
        } catch (PagoMatriculaPendienteException e) {
            System.err.println("Error de Pago: " + e.getMessage());
        } catch (DocumentacionIncompletaException e) {
            System.err.println("Error Documental (Runtime): " + e.getMessage());
        } finally {
            System.out.println("Registro de auditoría de matriculación cerrado.\n");
        }

        System.out.println("--- Caso 3: Matriculación Exitosa ---");
        try {
            procesador.confirmarMatricula(alumno, true, true);
        } catch (PagoMatriculaPendienteException e) {
            System.err.println("Error de Pago: " + e.getMessage());
        } catch (DocumentacionIncompletaException e) {
            System.err.println("Error Documental (Runtime): " + e.getMessage());
        } finally {
            System.out.println("Registro de auditoría de matriculación cerrado.");
        }
    }
}