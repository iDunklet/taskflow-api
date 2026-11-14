package com.taskflow.task.service;
import java.util.List;
import com.taskflow.task.entity.Task;
import com.taskflow.task.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    public Optional<Task> updateTask(Long id, Task updatedTask){
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()){
            Task task =existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            taskRepository.save(task);
        }
        return existingTask;
    }
    public boolean deleteTask(Long id){
        boolean deleted = false;
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }

}
