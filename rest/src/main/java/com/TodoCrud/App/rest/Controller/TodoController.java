package com.TodoCrud.App.rest.Controller;

import com.TodoCrud.App.rest.Model.Task;
import com.TodoCrud.App.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
@Autowired
private TodoRepository todoRepository;
    @GetMapping(value = "/")
    public String saludo(){
        return "Mi primera Api Rest!!";

    }

    @GetMapping(value = "/tasks")
    public List<Task> getTask(){
        return todoRepository.findAll();
    }

    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "save task";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable Long id,@RequestBody Task task){
        Task updatedTask = todoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescripcion(task.getDescripcion());
        todoRepository.save(updatedTask);
        return "updated Task";
    }

    @DeleteMapping(value ="/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        Task deletedTask= todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return "Deleted  Task";
    }

}
