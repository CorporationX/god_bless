package school.faang.task_49003;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread '" + threadName + "' is executing a chore '" + chore + "'");
            Thread.sleep(2000);
            System.out.println("Thread '" + threadName + "' executed a chore '" + chore + "'");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task interrupted: " + chore);
        }
    }
}
