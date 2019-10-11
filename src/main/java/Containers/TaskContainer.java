package Containers;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.ToDoTask;
import model.User;
import Service.TaskService;

@Controller
public class TaskContainer {

	@Autowired
	private TaskService taskService;

	

	@GetMapping("/addTaskForm")
	public ModelAndView showAddForm(@ModelAttribute("user_id") String user_id,@ModelAttribute("error") String error) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("userId", user_id);
		mv.addObject("error", error);
		mv.addObject("taskForm", new ToDoTask());
		return mv;
	}

	@GetMapping("/updateTaskForm")
	public ModelAndView showUpdateForm(@ModelAttribute("task_id") String task_id,
			@ModelAttribute("user_id") String user_id,@ModelAttribute("error") String error, Model model, HttpSession session) {
		ToDoTask task = null;
		User user = (User) session.getAttribute("user");
		List<ToDoTask> taskList = taskService.getTasks(user.getUser_Id());
		for(int i = 0; i < taskList.size(); i++) {
			if(task_id.equals(Integer.toString(taskList.get(i).getTask_id()))) {
				task = taskService.findTaskById(taskList.get(i).getTask_id());
				break;
			}
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userId", user_id);
		mv.addObject("taskId", task_id);
		mv.addObject("taskTitle", task.getTitle());
		mv.addObject("taskDesc", task.getDescription());
		mv.addObject("taskDueDate", task.getDueDate());
		mv.addObject("taskCompleted", task.getIsChecked());
		mv.addObject("error", error);
		mv.addObject("userForm", new ToDoTask());
		return mv;
	}

	@PostMapping("/addTask")
	public ModelAndView addTask(@ModelAttribute("user_id") String user_id, @ModelAttribute("taskForm") ToDoTask task,
			BindingResult result, Model model, RedirectAttributes redirectAttributes) throws ParseException {

		ModelAndView mv = new ModelAndView("redirect:login-success");
		redirectAttributes.addFlashAttribute("user_id", user_id);
		try {
			task.setLastModified(getDate());
			task.setUser_id(Integer.parseInt(user_id));
			// Addressing your comment:
			taskService.addTask(task);
		} catch (DataAccessException ex) {
			ModelAndView errorMV = new ModelAndView("redirect:addTaskForm");
			redirectAttributes.addFlashAttribute("user_id", user_id);
			redirectAttributes.addFlashAttribute("error", "Unable to Create Task, try adding data in format shown in placeholders");
			return errorMV;
		}
		return mv;

	}

	@GetMapping("/updateTaskStatus")
	public ModelAndView updateTask(@ModelAttribute("task_id") String task_id, @ModelAttribute("user_id") String user_id,
			final RedirectAttributes redirectAttributes) throws ParseException {

		ModelAndView mv = new ModelAndView("redirect:login-success");
		redirectAttributes.addFlashAttribute("user_id", user_id);
		try {
			java.sql.Date date = getDate();
			ToDoTask task = taskService.findTaskById(Integer.parseInt(task_id));

			taskService.updateTaskStatus(!task.getIsChecked(), date, Integer.parseInt(task_id));
		} catch (DataAccessException ex) {
			redirectAttributes.addFlashAttribute("error", "Unable to Update Status");
		}
		return mv;
	}

	@PostMapping("/updateTask")
	public ModelAndView updateTask(@ModelAttribute("task_id") String task_id, @ModelAttribute("user_id") String user_id,
			@ModelAttribute("userForm") ToDoTask task, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) throws ParseException {

		ModelAndView mv = new ModelAndView("redirect:login-success");
		redirectAttributes.addFlashAttribute("user_id", user_id);
		try {
			task.setLastModified(getDate());
			taskService.updateTask(task, Integer.parseInt(task_id));
		} catch (DataAccessException ex) {
			ModelAndView errorMV = new ModelAndView("redirect:updateTaskForm");
			redirectAttributes.addFlashAttribute("user_id", user_id);
			redirectAttributes.addFlashAttribute("task_id", task_id);
			redirectAttributes.addFlashAttribute("error", "Unable to Update Task, try adding data in format shown in placeholders");
			return errorMV;
		}
		return mv;
	}

	private java.sql.Date getDate() throws ParseException {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		String todayDate = year + "-" + month + "-" + day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(todayDate);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	@GetMapping("/deleteTask")
	public ModelAndView authenticate(@ModelAttribute("task_id") String task_id,
			@ModelAttribute("user_id") String user_id, Model model, final RedirectAttributes redirectAttributes) {

		ModelAndView mv = new ModelAndView("redirect:login-success");
		redirectAttributes.addFlashAttribute("user_id", user_id);

		try {
			taskService.deleteTask(Integer.parseInt(task_id));
			// mv.addObject("tasks", tasks);

		} catch (DataAccessException ex) {
			redirectAttributes.addFlashAttribute("error", "Unable to Delete Task");
		}
		return mv;
	}

}
