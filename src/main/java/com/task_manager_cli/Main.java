package com.task_manager_cli;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Must provide a command!");
        }

        String command = args[0].toLowerCase();
        command = command.toLowerCase();

        switch (command) {
            case "add":
                Task task = new Task(args);
        }

    }
}
