package com.ToDo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToDo.Model.ModelData;


@Repository
public interface TasksRespository extends JpaRepository<ModelData, String> {

 
}
