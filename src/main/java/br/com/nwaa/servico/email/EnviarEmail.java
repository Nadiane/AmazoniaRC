package br.com.nwaa.servico.email;

import br.com.nwaa.entidades.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviarEmail {

    public static void enviarEmail(final Email email){
        new Thread(new Runnable() {
            public void run() {
                enviar(email);
            }
        }).start();
    }

    private static void enviar(Email email) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(
                props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("wagner.dawis@gmail.com", "uni07.2wn");
                    }
                }
        );

        /* Ativa Debug para sessão */
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            //Remetente
            message.setFrom(new InternetAddress("wagner.dawis@gmail.com"));

            //Destinatários
            Address[] toUser = InternetAddress.parse(email.getPara());

            message.setRecipients(Message.RecipientType.TO, toUser);
            //Assunto
            message.setSubject(email.getAssunto());
            //Mensagem
            message.setText(email.getMensagem());

            /**Método para enviar a mensagem criada*/
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
