package com.myproject.taskmanager.mapper;

import com.myproject.taskmanager.dto.TaskDto;
import com.myproject.taskmanager.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toEntity(TaskDto taskDto);

    TaskDto toDto(Task task);
}