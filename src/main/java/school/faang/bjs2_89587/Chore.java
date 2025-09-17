package school.faang.bjs2_89587;

public class Chore implements Runnable {
    private String chore;
    private static final int SLEEP = 5000;

    public Chore(String chore) {
        this.chore = chore;
    }

    public void run() {
        System.out.printf("Thread performing task: %s Task: %s%n",
                Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            System.out.printf("Task %s was interrupted %n", chore);
            Thread.currentThread().interrupt();
            return;
        }
        System.out.printf("Task %s completed%n", chore);
    }
}
