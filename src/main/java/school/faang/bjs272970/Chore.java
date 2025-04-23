package school.faang.bjs272970;

public class Chore implements Runnable {
    private static final int SLEEP_DURATION_MS = 1000;
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Running chore " + chore + " by thread " + threadName);
        try {
            Thread.sleep(SLEEP_DURATION_MS);
            System.out.println("Finished chore " + chore + " by thread " + threadName);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}