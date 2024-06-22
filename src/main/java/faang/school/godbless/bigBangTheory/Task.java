package faang.school.godbless.bigBangTheory;

public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is starting the task: " + task);
            Thread.sleep(2000);
            System.out.println(name + " has completed the task: " + task);
        } catch (InterruptedException e) {
            System.err.println(name + " was interrupted while performing the task: " + task);
        }
    }
}
