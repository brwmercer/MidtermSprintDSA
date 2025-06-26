package main;

import user.User;
import java.util.Scanner;

public class ToDoManager {
    private User[] users;
    private int userCount;

    public ToDoManager(int maxUsers) {
        users = new User[maxUsers];
        userCount = 0;
    }

    public void createUser(String name) {
        if (userCount < users.length) {
            users[userCount++] = new User(name);
            System.out.println("User " + name + " created.");
        } else {
            System.out.println("User limit reached.");
        }
    }

    public User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }

    public void addTaskToUser(String userName, String taskDescription) {
        User user = getUser(userName);
        if (user != null) {
            user.addTask(taskDescription);
            System.out.println("Task added to " + userName + " list.");
        } else {
            System.out.println("USer not found.");
        }
    }
    public void markTaskCompleted(String userName, String taskDescription) {
        User user = getUser(userName);
        if (user != null) {
            user.markTaskAsCompleted(taskDescription);
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("User not found.");
        }
    }
    public void printUserTasks(String userName) {
        User user = getUser(userName);
        if (user != null) {
            user.printTasks();
        } else {
            System.out.println("User not found.");
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoManager manager = new ToDoManager(10);

        while (true) {
            System.out.println("\nTo Do Manager");
            System.out.println("1.Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Print user tasks");
            System.out.println("5. Finish");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter user name: ");
                    manager.createUser(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    manager.addTaskToUser(userName, taskDescription);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    taskDescription = scanner.nextLine();
                    manager.markTaskCompleted(userName, taskDescription);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    manager.printUserTasks(userName);
                    break;
                case 5:
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
