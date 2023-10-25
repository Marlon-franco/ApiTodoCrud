package com.TodoCrud.App.rest.Repository;

import com.TodoCrud.App.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long>{
}
