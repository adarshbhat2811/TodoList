package model;

import java.sql.Date;

public class ToDoTask {

	private int task_id, user_id;
	private String description, title;
	private Boolean isChecked;
	private Date lastModified, dueDate;

	public ToDoTask() {
	}

	public ToDoTask(int task_id, int user_id, String description, String title, Boolean isChecked, Date lastModified,
			Date dueDate) {
		super();
		this.task_id = task_id;
		this.user_id = user_id;
		this.description = description;
		this.title = title;
		this.isChecked = isChecked;
		this.lastModified = lastModified;
		this.dueDate = dueDate;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}