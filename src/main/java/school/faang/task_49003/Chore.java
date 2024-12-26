package school.faang.task_49003;

public class Chore implements Runnable {
    private static final int DELAY = 2000;
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread '" + threadName + "' is executing a chore '" + chore + "'");
            Thread.sleep(DELAY);
            System.out.println("Thread '" + threadName + "' executed a chore '" + chore + "'");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task interrupted: " + chore);
        }
    }
}
