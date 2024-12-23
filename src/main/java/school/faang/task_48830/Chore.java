package school.faang.task_48830;

public class Chore implements  Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " is starting the chore: " + chore);

        try {
            // Имитация выполнения задачи
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " was interrupted while doing " + chore);
        }

        System.out.println("Thread " + threadName + " has completed the chore: " + chore);
    }

}
