package user;

import tasklist.TaskList;

public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        taskList.addTask(new task.Task(description));
    }

    public void markTaskAsCompleted(String description) {
        taskList.markTaskAsCompleted(description);
    }

    public void printTasks() {
        System.out.println(name + " Task list: ");
        taskList.printTasks();
    }
}
