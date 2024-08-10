package khuedev_portfolio.portfolio.controller;

import khuedev_portfolio.portfolio.entity.ContactForm;
import khuedev_portfolio.portfolio.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private final EmailService emailService;
    public ContactController(EmailService theEmailService){
        emailService = theEmailService;
    }

    @PostMapping("/send")
    public String sendContactMessage(@ModelAttribute("contact") ContactForm contact){
        emailService.sendContactMessage(contact);
        return "redirect:/khuetruong/home";
    }

}
