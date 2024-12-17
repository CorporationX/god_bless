package school.faang.task_48356;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread: " + Thread.currentThread().getName() + " is processing task: " + chore);
            Thread.sleep(1000);
            System.out.println("The task: " + chore + " is completed");
        } catch (InterruptedException e) {
            System.out.println("The task " + chore + " interrupted");
        }
    }
}