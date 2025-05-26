package com.myproject.taskmanager.mapper;

import com.myproject.taskmanager.dto.TaskDto;
import com.myproject.taskmanager.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}