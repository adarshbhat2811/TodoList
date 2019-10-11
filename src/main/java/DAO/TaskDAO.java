package DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import model.*;


public class TaskDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ToDoTask> getTasks(int user_id) {
		List<ToDoTask> tasksList = jdbcTemplate.query("SELECT * FROM Tasks WHERE user_id = ? ORDER BY title", new TaskMapper(),
				new Object[] { user_id });
		return tasksList;
	}

	public void addTask(ToDoTask task) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(
				"INSERT INTO Tasks(title, description,due_date,lastModified,completed,user_id) VALUES(?,?,?,?,?,?)",
				new Object[] { task.getTitle(), task.getDescription(), task.getDueDate(), task.getLastModified(),
						task.getIsChecked(), task.getUser_id() });
		// }
	}

	public void updateTask(ToDoTask task, int task_id) throws DataAccessException {
		// TODO Auto-generated method stub

		jdbcTemplate.update(
				"UPDATE Tasks SET title = ?, description = ?, completed = ?, lastModified = ?, due_date = ? WHERE task_id = ?",
				new Object[] { task.getTitle(), task.getDescription(), task.getIsChecked(), task.getLastModified(),
						task.getDueDate(), task_id });

	}

	public void deleteTask(int task_id) throws DataAccessException {
		jdbcTemplate.update("DELETE FROM Tasks WHERE task_id = ?", new Object[] { task_id });
	}

	public ToDoTask findTaskById(int task_id) {

		ToDoTask task = jdbcTemplate.queryForObject("SELECT * FROM Tasks WHERE task_id = ?", new TaskMapper(),
				new Object[] { task_id });
		// TODO Auto-generated method stub
		return task;
	}

	public void updateTaskStatus(Boolean isChecked, Date lastModified, int task_id) {
		jdbcTemplate.update("UPDATE Tasks SET completed = ?,lastModified = ? WHERE task_id = ?",
				new Object[] { isChecked, lastModified, task_id });

		// TODO Auto-generated method stub

	}

}
