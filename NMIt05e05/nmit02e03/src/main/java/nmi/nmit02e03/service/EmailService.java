package nmi.nmit02e03.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender sender;

    public boolean sendEmail(String destination, String subject, String textMessage, String attachment) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("pruebascorreos.spring2024@gmail.com"); 
            helper.setTo(destination);
            helper.setText(textMessage, true);
            File archivoAdjunto = new File(attachment);
            helper.addAttachment(archivoAdjunto.getName(), archivoAdjunto);
            helper.setSubject(subject);
            sender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
