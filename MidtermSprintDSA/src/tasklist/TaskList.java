package tasklist;

import task.Task;

public class TaskList {
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public TaskList() {
        this.head = null;
        this.tail = null;
    }

    public void addTask(Task task) {
        if (task == null) {
            System.out.println("Task cannot be empty");
            return;
        }
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void markTaskAsCompleted (String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted();
                break;
            }
            current = current.next;
        }
    }

    public void printTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks to complete");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
