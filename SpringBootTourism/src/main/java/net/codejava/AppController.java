package net.codejava;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.entity.Customer;

import net.codejava.entity.List;
import net.codejava.repository.CustomerRepository;
import net.codejava.repository.ListRepository;
import net.codejava.service.CustomerService;
import net.codejava.service.ListService;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ListService listService;
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String packageList(Model model) {
		model.addAttribute("lists", listService.getAllList());
		return "packages";
	}
	
	@GetMapping("/admin")
	public String AdminPage() {
		return "admin";
	}
	
	@GetMapping("/addpackage")
	public String AddPackage(Model model) {
		model.addAttribute("list", new List());
		return "addPackage";
	}
	
	@GetMapping("/editpackage")
	public String EditPackage(Model model) {
		model.addAttribute("lists", listService.getAllList());
		return "editPackage";
	}
	
	@GetMapping("/editPackage/update/{id}")
	public String editPackageForm(@PathVariable Long id, Model model) {
		model.addAttribute("list", listService.getListById(id));
		return"edit_package";
	}
	
	@PostMapping("/package")
	public String savePackage(List list) {
		listRepository.save(list);
		return "admin";
	}
	
	@GetMapping("/editPackage/{id}")
	public String deletePackage(@PathVariable Long id) {
		listService.deletePackageById(id);
		return "redirect:/editpackage";
	}
	
	@PostMapping("/update/{id}")
	public String updatePackage(@PathVariable Long id,@ModelAttribute("list") List list, Model model) {
		
		//get student from database by id
		List existingPackage = listService.getListById(id);
		existingPackage.setId(id);
		existingPackage.setPlace(list.getPlace());
		existingPackage.setDescription(list.getDescription());
		existingPackage.setAreas(list.getAreas());
		existingPackage.setHotel(list.getHotel());
		existingPackage.setNoofdays(list.getNoofdays());
		//save updated student object
		listService.updatePackage(existingPackage);
		return "redirect:/editpackage";
		
	}
	
	@GetMapping("/book/{id}")
	public String Book( Model model) {
		model.addAttribute("customer", new Customer());
		return"Booking";
	}
	
	@PostMapping("/booking")
	public String bookPackage(Customer customer) {
		customerRepository.save(customer);
		return "bookingsucess";
	}
	
	@GetMapping("/bookedpackage")
	public String bookedPackage(Model model) {
		model.addAttribute("customers", customerService.getAllCustomer());
		return "booked";
	}
	
	@GetMapping("/editBooked/update/{id}")
	public String editBookedForm(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerService.getcustomerById(id));
		return"edit_booked";
	}
	
	@PostMapping("/updated/{id}")
	public String updateCustomer(@PathVariable Long id,@ModelAttribute("customer") Customer customer, Model model) {
		
		//get student from database by id
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setId(id);
		existingCustomer.setName(customer.getName());
		existingCustomer.setPhoneno(customer.getPhoneno());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setMember(customer.getMember());
		existingCustomer.setModeofvehicle(customer.getModeofvehicle());
		existingCustomer.setDate(customer.getDate());
		existingCustomer.setPackageno(customer.getPackageno());
		
		//save updated student object
		customerService.updateCustomer(existingCustomer);
		return "redirect:/bookedpackage";
		
	}
	
	@GetMapping("/deleteBooked/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return "redirect:/bookedpackage";
	}
	
	
	
	
}
