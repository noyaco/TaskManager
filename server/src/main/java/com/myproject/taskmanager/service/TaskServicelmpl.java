package com.myproject.taskmanager.service;

import com.myproject.taskmanager.dto.TaskDto;
import com.myproject.taskmanager.entity.Task;
import com.myproject.taskmanager.mapper.TaskMapper;
import com.myproject.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServicelmpl implements  TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper mapper;

    public TaskServicelmpl(TaskRepository taskRepository, TaskMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public List<TaskDto> getAllTask(){
        List<Task> tasks = taskRepository.findAll();
        tasks.forEach(task -> System.out.println("Task: " + task));
        List<TaskDto> taskDtos = tasks.stream()
                .map(mapper::toDto)
                        .collect(Collectors.toList());
        taskDtos.forEach(dto -> System.out.println("Mapped TaskDto: " + dto));
        return taskDtos;
    }
    public void deleteById(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }else
            throw new RuntimeException("not found id");


    }

    public TaskDto saveOrUpdateTask(TaskDto taskDto) {
        System.out.println("Data in DTO: " + taskDto.getDate());

        Task task = mapper.toEntity(taskDto);

        if (taskDto.getDate() == null || taskDto.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date must be today or in the future.");
        }

        task = taskRepository.save(task);

        return mapper.toDto(task);
    }


    public TaskDto toggleTask(Long id){
        Optional<Task> byId = taskRepository.findById(id);

        if(byId.isEmpty()){
            throw new RuntimeException("not found id" + id);
        }

        Task task = byId.get();

        task.setCompleted(!task.isCompleted());

        return mapper.toDto(taskRepository.save(task));
    }






}
