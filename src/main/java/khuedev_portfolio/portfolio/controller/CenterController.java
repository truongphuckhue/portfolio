package khuedev_portfolio.portfolio.controller;

import java.util.List;

import khuedev_portfolio.portfolio.entity.ContactForm;
import khuedev_portfolio.portfolio.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import khuedev_portfolio.portfolio.entity.Employee;

@Controller
@RequestMapping("/khuetruong")
public class CenterController {

	private EmployeeService employeeService;

	public CenterController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"
	@GetMapping("/home")
	public String demo(Model model){
		return "employees/trangchu";
	}
	@GetMapping("/project")
	public String project(Model model){
		return "employees/project";
	}
	@GetMapping("/contact")
	public String contact(Model model){
		ContactForm contactForm = new ContactForm();
		model.addAttribute("contactForm", contactForm);
		return "employees/contact";
	}
	@GetMapping("/aboutme")
	public String aboutme(){
		return "employees/aboutme";
	}
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// get the employees from db
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {

		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to our form
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// delete the employee
		employeeService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/employees/list";

	}
}









