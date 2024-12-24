package school.faang.cachechores;

public class Chore implements Runnable {
    public static final int SLEEP_IN_MILLIS = 1000;
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s starting process for chore: %s", Thread.currentThread().getName(), chore));
        try {
            Thread.sleep(SLEEP_IN_MILLIS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
        System.out.println(String.format("%s ending process for chore: %s", Thread.currentThread().getName(), chore));
    }
}

