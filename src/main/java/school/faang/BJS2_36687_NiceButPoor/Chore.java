package school.faang.BJS2_36687_NiceButPoor;

public class Chore implements Runnable{
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.printf("Thread with name '%s' has been started to do the chore: %s\n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted while doing the chore: " + chore, e);
        }
        System.out.printf("Thread with name '%s' has completed the chore: %s\n", Thread.currentThread().getName(), chore);
    }
}
