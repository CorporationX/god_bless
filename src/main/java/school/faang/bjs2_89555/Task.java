package school.faang.bjs2_89555;

import lombok.SneakyThrows;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @SneakyThrows
    public void run() {
        System.out.println("Start task: " +
                "Employee: " + name +
                "Task: " + task);
        try {
            Thread.sleep(5000);
            System.out.println("Task " + task + " completed");
        } catch (InterruptedException e) {
            System.out.println("Task " + task + " was interrupted");
        }
    }
}
