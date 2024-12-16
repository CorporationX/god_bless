package school.faang.task_48880;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " task in progress: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " task completed.");
        } catch (InterruptedException e) {
            throw new RuntimeException(chore + " task interrupted.");
        }
    }
}
