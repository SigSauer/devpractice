package com.sigsauer.devpractice.learning.email;

import com.sigsauer.devpractice.learning.gson.JsonController;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSendEngine {
    static Map<String, String> login;

    public static void main(String[] args) {
        login = JsonController.getJsonData("C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\email\\authentication.json");

        String to = "danie2747@gmail.com";
        String from = "john.mayer.19780525@gmail.com";
        //get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login.get("login"), login.get("password"));
            }
        });
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Subject");
            message.setText("Text");


            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
