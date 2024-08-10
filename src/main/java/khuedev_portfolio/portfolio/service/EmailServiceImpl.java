package khuedev_portfolio.portfolio.service;

import khuedev_portfolio.portfolio.entity.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendContactMessage(ContactForm contact) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("khuetp51@gmail.com");
        mailMessage.setSubject("New Contact Form Submission");
        mailMessage.setText("Name: " + contact.getName() + "\nEmail: " + contact.getEmail() + "\nMessage: " + contact.getMessage());
        javaMailSender.send(mailMessage);
    }
}
