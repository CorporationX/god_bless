package school.faang.task_48830;

public class Chore implements  Runnable {

    static final int SLEEP_TIME = 2000;

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " is starting the chore: " + chore);

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " was interrupted while doing " + chore);
        }

        System.out.println("Thread " + threadName + " has completed the chore: " + chore);
    }

}
