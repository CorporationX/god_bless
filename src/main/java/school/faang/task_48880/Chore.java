package school.faang.task_48880;

public class Chore implements Runnable {
    static final long SLEEP_TIME = 1000;
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " task in progress: " + chore);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(chore + " task interrupted.");
        }
        System.out.println(chore + " task completed.");
    }
}
