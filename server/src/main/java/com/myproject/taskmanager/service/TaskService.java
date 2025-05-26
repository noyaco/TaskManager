package com.myproject.taskmanager.service;

import com.myproject.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTask();

    void deleteById(Long id);

    TaskDto saveOrUpdateTask(TaskDto taskDto);

    TaskDto toggleTask(Long id);


    }






