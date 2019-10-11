package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TaskMapper implements RowMapper<ToDoTask> {

	@Override
	public ToDoTask mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		ToDoTask task = new ToDoTask();

		task.setDescription(rs.getString("description"));
		task.setIsChecked(rs.getBoolean("completed"));
		task.setTitle(rs.getString("title"));
		task.setLastModified(rs.getDate("lastModified"));
		task.setDueDate(rs.getDate("due_date"));
		task.setTask_id(rs.getInt("task_id"));
		task.setUser_id(rs.getInt("user_id"));
		return task;
	}
}