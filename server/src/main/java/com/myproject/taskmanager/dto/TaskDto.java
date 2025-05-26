package com.myproject.taskmanager.dto;



import java.time.LocalDate;





public class TaskDto {

    private Long id;
    private String title;
    private LocalDate date;
    private boolean completed;

    public TaskDto(Long id, String title, LocalDate date, boolean completed) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}