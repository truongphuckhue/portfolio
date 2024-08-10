package khuedev_portfolio.portfolio.service;

import khuedev_portfolio.portfolio.entity.ContactForm;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface EmailService {
    void sendContactMessage(ContactForm contact);
}
