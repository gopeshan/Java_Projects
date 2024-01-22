import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }
}

class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("New task added: \"" + description + "\"");
    }
public void markTaskCompleted(int index) {
        if (isValidIndex(index)) {
            Task task = tasks.get(index);
            task.markCompleted();
            System.out.println("Task marked as completed: \"" + task.getDescription() + "\"");
        } else {
            System.out.println("Invalid task index. Please choose a valid task.");
        }
    }

    public void displayTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getDescription() +
                    (task.isCompleted() ? " - Completed" : ""));
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
    
}

public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add New Task\n2. Mark Task as Done\n3. Display Tasks\n4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                
                    
            }
            
        }
    }
}
