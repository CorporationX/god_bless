package school.faang.task_48366;

public class Chore implements Runnable {
    private static final int SLEEP_TIME_MILLIS = 1000;

    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " performs the task: " + chore);
            Thread.sleep(SLEEP_TIME_MILLIS);
            System.out.println(chore + " done!");
        } catch (InterruptedException e) {
            System.out.println("The task " + chore + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}