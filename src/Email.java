import java.util.ArrayList;
import java.util.List;

    public class Email {
    private List<String> destinatarios;
    private String asunto;
    private String cuerpo;
    private List<String> adjuntos;

    private Email(EmailBuilder builder) {
        this.destinatarios = builder.destinatarios;
        this.asunto = builder.asunto;
        this.cuerpo = builder.cuerpo;
        this.adjuntos = builder.adjuntos;
    }

    public void mostrarCorreo() {
        System.out.println("Destinatarios: " + destinatarios);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        if (adjuntos != null && !adjuntos.isEmpty()) {
            System.out.println("Adjuntos: " + adjuntos);
        } else {
            System.out.println("No hay adjuntos.");
        }
    }

    public static class EmailBuilder {
        private List<String> destinatarios = new ArrayList<>();
        private String asunto;
        private String cuerpo;
        private List<String> adjuntos = new ArrayList<>();

        public EmailBuilder agregarDestinatario(String destinatario) {
            this.destinatarios.add(destinatario);
            return this;
        }

        public EmailBuilder agregarAsunto(String asunto) {
            this.asunto = asunto;
            return this;
        }

        public EmailBuilder agregarCuerpo(String cuerpo) {
            this.cuerpo = cuerpo;
            return this;
        }

        public EmailBuilder agregarAdjunto(String adjunto) {
            this.adjuntos.add(adjunto);
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del patrón Builder
        Email email = new Email.EmailBuilder()
                .agregarDestinatario("dcontrerasd@miumg.edu.gt")
                .agregarDestinatario("dconduar@gmail.com")
                .agregarAsunto("Asunto del Correo")
                .agregarCuerpo("Cuerpo del Correo")
                .agregarAdjunto("Archivo1Pdf")
                .agregarAdjunto("Archivo2png")
                .build();

        email.mostrarCorreo();
    }
}
