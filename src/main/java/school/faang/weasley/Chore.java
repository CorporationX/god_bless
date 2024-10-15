package school.faang.weasley;

public class Chore implements Runnable {
    private final String CHORE;

    public Chore(String CHORE) {
        this.CHORE = CHORE;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " performs the task: " + CHORE);
            Thread.sleep(1000);
            System.out.println(CHORE + " completed!");
        } catch (InterruptedException e) {
            System.out.println("Task " + CHORE + " was interrupted.");
        }
    }
}