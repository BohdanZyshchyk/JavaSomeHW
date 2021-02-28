package app.mail;


import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
    void sendSimpleMessage(SimpleMailMessage message);
}