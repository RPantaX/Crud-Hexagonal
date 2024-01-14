package org.example.arquitecturahexagonal.infrastructure.controllers;

import org.example.arquitecturahexagonal.application.services.TaskService;
import org.example.arquitecturahexagonal.domain.models.AditionalTaskInfo;
import org.example.arquitecturahexagonal.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tastks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createTask=taskService.createTask(task);
        return new ResponseEntity<>(createTask, HttpStatus.CREATED);
    }
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable("taskId") Long taskId){
        return taskService.getTask(taskId)
                .map(task->new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        //le pasamos esto porque si no le pasamos un id petaria un error.
    }

    @GetMapping
    public ResponseEntity <List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
        //si acá no nos devuelve nd seria un vacio pero no habría un error
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updateTask){
        return taskService.updateTask(taskId, updateTask)
                .map(task->new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId){
        if(taskService.deleteTask(taskId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{taskId}/aditionalInfo")
    public ResponseEntity<AditionalTaskInfo> getAditionalTaskInfo(@PathVariable("taskId") Long taskId){
        AditionalTaskInfo aditionalTaskInfo= taskService.getAdditionalTaskInfo(taskId);
        return new ResponseEntity<>(aditionalTaskInfo, HttpStatus.OK);
    }
}
