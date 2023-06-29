package faang.school.godbless.TheBigBangTheory;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("Start making: " + task + " by " + name);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("The task was interrupted");
        }
    }
}
