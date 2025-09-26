package com.task_manager_cli;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Task {

    private int id;
    private StringBuilder description;
    private Status status;
    private String creationDateTime;
    private String updatedAtDateTime;

    public Task(String[] args){
        id = generateNextId();
        description = setDescription(args);
        status = Status.TODO;
        creationDateTime = setCreationDateTime();
        updatedAtDateTime = setUpdatedAtDateTime();
        String task = "{"
                + "\"id\":\"" + id + "\"{"
                + "\"taskDescription\":\"" + description + "\","
                + "\"status\":\"" + status + "\","
                + "\"creationDateTime\":\"" + creationDateTime + "\","
                + "\"updatedAtDateTime\":\"" + updatedAtDateTime + "\""
                + "}"
                + "}";
        try (FileWriter jsonFile = new FileWriter("tasks.json", true)) {
            jsonFile.write(task);
            System.out.println("File created successfully!");
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    Set<Integer> ids = new HashSet<>();

    public int generateNextId() {
        int maxID = 0;
        for (Integer id : ids) {
            if (maxID < id) {
                maxID = id;
            }
        }
        int newID = maxID + 1;
        ids.add(newID);
        return newID;
    }

    public StringBuilder setDescription(String[] args) {
        StringBuilder taskDescription = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            taskDescription.append(args[i]).append(" ");
        }
        taskDescription.trimToSize();
        return taskDescription;
    }

    public String setCreationDateTime(){
        LocalDateTime creationDateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = formatter.format(creationDateAndTime);
        return formattedDateTime;
    }

    public String setUpdatedAtDateTime(){
        LocalDateTime creationDateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = formatter.format(creationDateAndTime);
        return formattedDateTime;
    }



}
