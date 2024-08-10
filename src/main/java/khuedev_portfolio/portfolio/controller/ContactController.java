package khuedev_portfolio.portfolio.controller;

import khuedev_portfolio.portfolio.entity.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public String sendContactMessage(@ModelAttribute("contact") ContactForm contact, RedirectAttributes redirectAttributes){
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("khuetp51@gmail.com");
            mailMessage.setSubject("New Contact Form Submission");
            mailMessage.setText("Name: " + contact.getName() + "\nEmail: " + contact.getEmail() + "\nMessage: " + contact.getMessage());
            javaMailSender.send(mailMessage);
            redirectAttributes.addFlashAttribute("successMessage", "Email sent successfully!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Error sending email: " + e.getMessage());
        }
        return "redirect:/khuetruong/home";
    }

}
