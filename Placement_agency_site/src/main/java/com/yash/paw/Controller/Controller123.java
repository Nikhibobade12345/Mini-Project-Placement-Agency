package com.yash.paw.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yash.paw.Repo.RecruiterRepo1;
import com.yash.paw.Repo.UserRepo1;
import com.yash.paw.model.Recruiter;
import com.yash.paw.model.User;
import com.yash.paw.service.RecruiterService1;
import com.yash.paw.service.UserService1;

@Controller
public class Controller123 {

	public Integer rid=0;
	@Autowired
	UserService1 Uservice;
	@Autowired
	RecruiterService1 Rservice;
	@Autowired
	private UserRepo1 eRepo;
	@Autowired
	private RecruiterRepo1 eRepo1;

	@GetMapping("/list1")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("list1");
		mav.addObject("users", eRepo.findAll());
		return mav;
	}

	@GetMapping("/list2")
	public ModelAndView getAllRecruiter() {
		ModelAndView mav = new ModelAndView("list2");
		mav.addObject("recruiters", eRepo1.findAll());
		return mav;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home- Placement Agenecy");
		return "list";
	}

	@GetMapping("/Feedback")
	public ModelAndView Myprofile() {
		ModelAndView mav = new ModelAndView("Review");
		User newUser = new User();
		mav.addObject("user1", newUser);
		return mav;
	}

	@GetMapping("/login")
	public String Login(Model mr,@RequestParam("RId") Integer id) {
		System.out.println(id+"Recruiter Id");
		rid=id;
		User user = new User();
		mr.addAttribute("user9", user);
		return "login";
	}

	@GetMapping("/rLogin")
	public String RLogin(Model mr) {

		Recruiter recuiter = new Recruiter();
		mr.addAttribute("recruiter9", recuiter);
		return "rLogin";
	}
	@GetMapping("/uLogin")
	public String uLogin(Model mr) {
User user=new User();
mr.addAttribute("user10", user);
		
		return "uLogin";
	}
	@PostMapping("/u1login")
	public String uloginSucess(@ModelAttribute("user10") User u1) {

		System.out.println(u1.getPassword());
		User r = eRepo.findUserBypassword(u1.getPassword());
		int id = r.getUserid();

		if (r != null) {

			 return "redirect:/details3/" + id; 
			
		} else
			return "error";
	}

	@PostMapping("/userlogin")
	public String loginSucess(@ModelAttribute("user9") User user1) {

		System.out.println(user1.getPassword());

		User u = eRepo.findUserBypassword(user1.getPassword());
		int id = u.getUserid();
		System.out.println(id);
		if (u != null) {

			return "redirect:/details/" + id;
		} else
			return "error";
	}

	@PostMapping("/recruiterlogin")
	public String rloginSucess(@ModelAttribute("recruiter9") Recruiter r1) {

		System.out.println(r1.getPassword());
		Recruiter r = eRepo1.findRecruiterBypassword(r1.getPassword());
		int id = r.getId();

		if (r != null) {

			 return "redirect:/details2/" + id; 
			
		} else
			return "error";
	}

	@GetMapping("/addUserForm")
	public ModelAndView addUserForm() {
		ModelAndView mav = new ModelAndView("add-user-form");
		User newUser = new User();
		mav.addObject("user", newUser);
		return mav;
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add-user-form";
		} else

			eRepo.save(user);

		return "redirect:/list1";
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Integer userId) {
		ModelAndView mav = new ModelAndView("add-user-form");
		User user = eRepo.findById(userId).get();
		mav.addObject("user", user);
		return mav;
	}
	@GetMapping("/showUpdateFormrecruiter")
	public ModelAndView show_Update_Form_recruiter(@RequestParam Integer rId) {
		ModelAndView mav = new ModelAndView("add-recruiter-form");
		Recruiter recruiter = eRepo1.findById(rId).get();
		mav.addObject("recruiter", recruiter);
		return mav;
	}
	

	@GetMapping("/details/{id}")
	public String view(@PathVariable int id, Model m) {
		m.addAttribute("detaild", eRepo.findById(id).get());
		m.addAttribute("rdetails",eRepo1.findById(rid.intValue()).get());
		return "details";
	}

	@GetMapping("/details2/{id}")
	public String view2(@PathVariable(value = "id") int id, Model m) {
		m.addAttribute("detaild2", eRepo1.findById(id).get());
		return "details2";
	}
	@GetMapping("/details3/{id}")
	public String view3(@PathVariable(value = "id") int userId, Model m) {
		
		m.addAttribute("detaild3", eRepo.findById(userId).get());
	
		return "details3";
	}	
		
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam Integer userId) {
		eRepo.deleteById(userId);
		return "redirect:/list1";
	}

	@RequestMapping(path = { "/", "/list" })
	public String home1(Recruiter rs, Model model1, String keyword) {
		if (keyword != null) {
			List<Recruiter> list = Rservice.getByKeyword(keyword);
			model1.addAttribute("recruiters", list);
		} else {
			List<Recruiter> list = Rservice.getAllRecruiters();
			model1.addAttribute("recruiters", list);
		}
		return "/list";
	}

	@GetMapping("/addRecruiterForm")
	public ModelAndView addRecruiterForm() {
		ModelAndView mav = new ModelAndView("add-recruiter-form");
		Recruiter newRecruiter = new Recruiter();
		mav.addObject("recruiter", newRecruiter);
		return mav;
	}

	@PostMapping("/saveRecruiter")
	public String saveRecruiter(@Valid @ModelAttribute Recruiter recruiter, BindingResult result) {
		if (result.hasErrors()) {
			return "/add-recruiter-form";
		}

		eRepo1.save(recruiter);
		return "redirect:/list";
	}

	@GetMapping("/deleteRecruiter")
	public String deleteRecruiter(@RequestParam Integer recruiterId) {
		eRepo1.deleteById(recruiterId);
		return "redirect:/list";
	}

	@GetMapping("/applyForm")
	public ModelAndView applyForm(@RequestParam Integer recruiterId) {
		ModelAndView mav = new ModelAndView("list");
		Iterable<Recruiter> recruiter = eRepo1.findAll();
		mav.addObject("user4", recruiter);
		return mav;
	}

	@GetMapping("/Feedback1")
	public ModelAndView Recruiterprofile() {
		ModelAndView mav = new ModelAndView("Review1");
		User newUser = new User();
		mav.addObject("recruiter1", newUser);
		return mav;
	}
}
