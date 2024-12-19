package school.faang.task_48356;

public class Chore implements Runnable {
    private final Chores chores;

    public Chore(Chores chores) {
        this.chores = chores;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread: " + Thread.currentThread().getName() + " is processing task: " + chores);
            Thread.sleep(1000);
            System.out.println("The task: " + chores + " is completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}