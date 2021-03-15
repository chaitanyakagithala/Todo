package com.ToDo.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ToDo.Model.ModelData;
import com.ToDo.Repository.TasksRespository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private TasksRespository repository;

	public List<ModelData>  getTasks() {
		
	    return repository.findAll();
	    
	}

	public ModelData      addTask(ModelData task) {
		 repository.save(task);
		 return task;
	}

	public ModelData      updateStatus(ModelData task) {
	
		return repository.save(task);
	}

	public void    deleteTask(ModelData task) {
	  
		repository.delete(task);
		
	}

	

}
