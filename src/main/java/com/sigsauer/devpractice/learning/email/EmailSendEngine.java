//package com.sigsauer.devpractice.learning.email;
//
//import com.sigsauer.devpractice.learning.gson.JsonController;
//import java.util.Map;
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class EmailSendEngine {
//
//    public static void main(String[] args) {
//        Map<String, String> data = JsonController.getJsonData("src\\main\\resources\\email\\email.json");
//
//        //set properties
//        Properties properties = System.getProperties();
//        properties.put("mail.smtp.host",data.get("host"));
//        properties.put("mail.smtp.port", data.get("ssl"));
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(data.get("login"), data.get("password"));
//            }
//        });
//
//        session.setDebug(true);
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(data.get("login")));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("admin.lms@ukr.net"));
//            message.setSubject("Test SMTP message");
//            message.setText("Test SMTP message");
//
//
//            Transport.send(message);
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
