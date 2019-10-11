package Containers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Service.TaskService;
import Service.UserService;
import model.ToDoTask;
import model.User;

@Controller
public class UserContainer {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/") 
	public ModelAndView home(){
	    ModelAndView loginSuccess = new ModelAndView("redirect:index1");
	    return loginSuccess;
	} 

	@GetMapping("/index1")
	public ModelAndView showLoginForm(@ModelAttribute("error") String error, HttpSession session, final RedirectAttributes redirectAttributes) {
		ModelAndView mv = null;
		User loggedInUser = null;
		try{
			loggedInUser = (User) session.getAttribute("user");
		if(loggedInUser != null) {
			redirectAttributes.addAttribute("user_id", loggedInUser.getUser_Id());
			ModelAndView loginSuccess = new ModelAndView("redirect:login-success");
			return loginSuccess;
		}else {
		mv = new ModelAndView();
		System.out.println(error);
		mv.addObject("error", error);
		}
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		return mv;
		
		
	}

	@GetMapping("/login-success")
	public ModelAndView showLoginSuccess(@ModelAttribute("user_id") int id) {
	
		List<ToDoTask> tasks = taskService.getTasks(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("tasks", tasks);
		mv.addObject("user_id", id);
		return mv;
	}
	//

	@PostMapping("/authenticateUser")
	public ModelAndView authenticate(@ModelAttribute("userName") String username,
			@ModelAttribute("password") String password, Model model, final RedirectAttributes redirectAttributes, HttpSession httpSession) {
		User user = null;
		User loggedInUser = (User) httpSession.getAttribute("user");
		
		if(loggedInUser == null) {
		user = userService.authenticateUser(username, password);
		}else {
			user = userService.authenticateUser(loggedInUser.getUsername(), loggedInUser.getPassword());
		}

		if (user != null) {
			ModelAndView loginSuccess = new ModelAndView("redirect:login-success");
			redirectAttributes.addFlashAttribute("user_id", user.getUser_Id());
			httpSession.setAttribute("user", user);
			return loginSuccess;
		}
		// return error message and back to login form
		ModelAndView mv = new ModelAndView("redirect:index1");
		redirectAttributes.addFlashAttribute("error", "Invalid Username/Password");
		return mv;

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session ) {
	    session.invalidate();
	    return "redirect:/index1";
	} 
}
