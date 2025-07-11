package task;

public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return description + "---" + (isCompleted ? "Completed" : "Pending");
    }
}
