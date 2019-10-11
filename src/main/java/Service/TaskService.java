package Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import DAO.TaskDAO;
import model.ToDoTask;

public class TaskService {

	@Autowired
	private TaskDAO taskDAO;

	public List<ToDoTask> getTasks(int user_id) {
		return taskDAO.getTasks(user_id);
	}

	public void addTask(ToDoTask task) {
		taskDAO.addTask(task);
	}

	public void updateTask(ToDoTask task, int task_id) throws DataAccessException {
		taskDAO.updateTask(task, task_id);
	}

	public void deleteTask(int task_id) throws DataAccessException {
		taskDAO.deleteTask(task_id);
	}

	public ToDoTask findTaskById(int task_id) {

		// TODO Auto-generated method stub
		return taskDAO.findTaskById(task_id);
	}

	public void updateTaskStatus(Boolean isChecked, Date lastModified, int task_id) {

		taskDAO.updateTaskStatus(isChecked, lastModified, task_id);
		// TODO Auto-generated method stub

	}

}
