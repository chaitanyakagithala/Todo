package com.ToDo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ToDo.Model.ModelData;
import com.ToDo.Repository.TasksRespository;
import com.ToDo.Service.Service;

@Controller
public class TaskController {
	
	@Autowired
	private Service service;
		
	
	
	@RequestMapping("/getTaks")
	public ResponseEntity<List<ModelData>> GetTasks() {
		List<ModelData> list = service.getTasks();
		
		return new ResponseEntity<List<ModelData>>(list,HttpStatus.OK);
	}
     
	@RequestMapping("/")
	public String todo() {
		return"index";
	}
	
	
	
	@PostMapping("/AddTask")
	public String addTask(@RequestBody ModelData task ) {
		 service.addTask(task);
		 return "index";
	}
	
	
	@RequestMapping("/updateStatus")
	public String Updatestatus(@RequestBody ModelData task) {
		 service.updateStatus(task);
		 return "index";
	}
	
	@RequestMapping("/deleteTask")
	public String DeleteTask(@RequestBody ModelData task) {
		service.deleteTask(task);
		return "index";
		}
	
}
