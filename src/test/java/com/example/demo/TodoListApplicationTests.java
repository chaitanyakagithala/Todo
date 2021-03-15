package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ToDo.Model.ModelData;
import com.ToDo.Repository.TasksRespository;
import com.ToDo.Service.Service;

@ExtendWith(MockitoExtension.class)
class TodoListApplicationTests {

	@InjectMocks
	 Service service;
	@Mock
	TasksRespository repository ;
	
	@BeforeEach
	void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
		 
	}
	
	@Test
	public void getTaskstest() {
		
		when(repository.findAll()).thenReturn(Stream.of(new ModelData("task1",true)).collect(Collectors.toList()));
		assertEquals(1, service.getTasks().size());
	}
	
	@Test
	public void AddTask() {
		ModelData task = new ModelData("task1",true);
		when(repository.save(task)).thenReturn(task);
		assertEquals(task, service.addTask(task));
	}
	
	@Test
	public void deleteTask() {
		ModelData task = new ModelData("task1",true);
		service.deleteTask(task);
		verify(repository,times(1)).delete(task);
	}
	
	@Test
	public  void updateStatustest() {
	ModelData task = new ModelData("task1",true);
	when(repository.save(task)).thenReturn(task);
	 assertEquals(task, service.updateStatus(task));
	
	}
	
	

}
