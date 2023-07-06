package faang.school.godbless.Sprint4.Task_6_BigBang;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("Task " + task + " started by " + name);
        try {
            Thread.sleep(2000);
            System.out.println("Task " + task + " completed by " + name);
        } catch (InterruptedException e) {
            System.out.println("Task " + task + " being executed by " + name + " was interrupted");
        }
    }
}
