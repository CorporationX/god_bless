package school.faang.bjs248399;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " started the task: " + task);
            Thread.sleep(2000);  // task running simulation
            System.out.println(name + " completed the task: " + task);
        } catch (InterruptedException e) {
            System.err.println(name + " interrupted the task: " + task);
        }
    }
}