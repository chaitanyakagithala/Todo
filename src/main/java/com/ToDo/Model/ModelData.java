package com.ToDo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@Entity
public class ModelData {
	@Id
	private String task;
	private boolean Status;
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Task [ task=" + task + ", Status=" + Status + "]";
	}
	public ModelData(String task, boolean status) {
		super();
		this.task = task;
		Status = status;
	}
	public ModelData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
