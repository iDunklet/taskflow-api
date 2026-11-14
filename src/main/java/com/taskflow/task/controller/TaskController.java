
package com.taskflow.task.controller;
import java.util.List;
import java.util.Optional;

import com.taskflow.task.entity.Task;
import com.taskflow.task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.getTaskById(id);
        ResponseEntity<Task> answer;
        if (task.isPresent()) {
            answer=ResponseEntity.ok(task.get());
        } else{
            answer=ResponseEntity.notFound().build();
        }
        return answer;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task updatedTask){
        Optional<Task> task = taskService.updateTask(id, updatedTask);
        ResponseEntity<Task> answer;
        if (task.isPresent()){
            answer=ResponseEntity.ok(task.get());
        }else {
            answer=ResponseEntity.notFound().build();
        }
        return answer;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedTask(@PathVariable Long id){
        boolean deleted = taskService.deleteTask(id);
        ResponseEntity<Void> answer;
        if (deleted){
            answer=ResponseEntity.noContent().build();
        }else {
            answer=ResponseEntity.notFound().build();
        }
        return answer;
    }

}
