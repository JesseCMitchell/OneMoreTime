package com.codingdojo.omt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.codingdojo.omt.models.LoginUser;
import com.codingdojo.omt.models.Program;
import com.codingdojo.omt.models.User;
import com.codingdojo.omt.services.ProgramService;
import com.codingdojo.omt.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userServ;
	
	@Autowired 
	private ProgramService programServ;
	
//	========== Landing Page ==================
	@GetMapping("/")
	public String index(HttpSession session) {
		
		return "index.jsp";
	}
	
	// ========== Route for Login/Reg Page =======================
		@GetMapping("/createaccount")
	    public String account(Model model) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "register.jsp";
	    }
		
//	// ========== Use This to Test Login/Reg, then comment out once item displayall items is up ====
//		@GetMapping("/dashboard")
//		public String home(Model model, HttpSession session) {
//			if(session.getAttribute("uuid") == null) {
//				return "redirect:/logout";
//			}
//			Long uuid = (long) session.getAttribute("uuid");
//			model.addAttribute("user", userServ.findById(uuid));
//			return "dashboard.jsp";
//		}
	
	// ============ Register New User =============================
		@PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	        User user = userServ.register(newUser, result);
			
			if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
			session.setAttribute("uuid", user.getId());
	        
	        return "redirect:/dashboard";
	    }
		
		
		 
	// ============ Login =============================

		@PostMapping("/login")
		public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		     
			User user = userServ.login(newLogin, result);
		 
		    if(result.hasErrors() || user==null) {
		        model.addAttribute("newUser", new User());
		        return "index.jsp";
		    }
		     
		    session.setAttribute("uuid", user.getId());
		 
		    return "redirect:/dashboard";
		}
		
	// ============ Logout =============================
		@GetMapping("/logout")
		public String logout(HttpSession session) {
		 
			// Set uuid to null and redirect to login/register page
			session.setAttribute("uuid", null);
		     
		    return "redirect:/";
		}
		
		
	// ============ Create Program ====================
		@GetMapping("/new")
		public String addProgram(@ModelAttribute("program") Program program, HttpSession session) {
			if(session.getAttribute("uuid") == null) {
				return "redirect:/logout";
			}
			return "new.jsp";
		}
		
		@PostMapping("/new")
		public String addProgram(@Valid @ModelAttribute("program") Program program, BindingResult result, Model model, HttpSession session) {
			Long uuid = (Long) session.getAttribute("uuid");
			if(uuid == null) {
				return "redirect:/logout";
			}
			if(result.hasErrors()) {
				return "new.jsp";
			}else {
		
				programServ.addProgram(new Program(program.getName(), program.getZip(), program.getPhone(), program.getEmail(), program.getDescription(), program.getUrl(), program.getPhoto(), userServ.findById(uuid)));
				return "redirect:/dashboard";
			}
		}
		
	// ============ Upload Photos ====================	
	
		
	// ============ Display ALL Programs ==============
		@GetMapping("/dashboard")
		public String showPrograms(HttpSession session, Model model) {
			if(session.getAttribute("uuid") == null) {
				return "redirect:/logout";
			}
			List<Program> programs = programServ.allPrograms();
			model.addAttribute("programs", programs);
			Long uuid = (long) session.getAttribute("uuid");
			model.addAttribute("user", userServ.findById(uuid));
			return "dashboard.jsp";
		}
		
	// ============ Display One Show ===============
		@GetMapping("/programs/{id}")
		public String showPrograms(@PathVariable("id") Long id, HttpSession session, Model model) {
		 
			Long uuid = (Long) session.getAttribute("uuid");
			if(uuid == null) {
				return "redirect:/logout";
			}
			
			model.addAttribute("user", userServ.findById(uuid));
		     
			Program program = programServ.findProgram(id);
			model.addAttribute("program", program);
		     
		    return "view_program.jsp";
		}
		
	// ============ Update Show ====================
		
		@GetMapping("/programs/{id}/edit")
		public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {	
			Long uuid = (Long) session.getAttribute("uuid");
			if(uuid == null) {
				return "redirect:/logout";
			}
			if(session.getAttribute("uuid") == null) {
				return "redirect:/logout";
			}

			Program program = programServ.findProgram(id);
			if(uuid != program.getUser().getId()) {
				return "redirect:/dashboard";
			}
			model.addAttribute("program", program);
			return "edit.jsp";
		}
		
		@PutMapping("/programs/{id}/edit")
		public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("progam") Program program, BindingResult result, HttpSession session) {	
			
			if(session.getAttribute("uuid") == null) {
				return "redirect:/logout";
			}
			Long uuid = (Long) session.getAttribute("uuid");
			Program thisProgram = programServ.findProgram(id);

			if(uuid != thisProgram.getUser().getId()) {
				return "redirect:/dashboard";
			}
			if(result.hasErrors()) {
				return "edit.jsp";
			}else {
				
				program.setUser(thisProgram.getUser());
				program.setUser(userServ.findById(uuid));
				
				programServ.updateProgram(program);
				return "redirect:/dashboard";
			}
		}
		
	// ============ Delete Show ====================
		
		@DeleteMapping("/programs/delete/{id}")
		public String deleteProgram(@PathVariable("id") Long id, HttpSession session) {
			 
			if(session.getAttribute("uuid") == null) {
				return "redirect:/logout";
			}
	    	 
	    	programServ.deleteProgram(id);
	    	 
	    	return "redirect:/dashboard";
		}
}
