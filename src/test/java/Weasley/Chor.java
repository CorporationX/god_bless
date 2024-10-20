package Weasley;

public class Chor implements Runnable {
    private String task;

    public Chor(String task) {
        this.task = task;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " completes the task " + task);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("the task " + task + " was interrupted");
            e.printStackTrace();
        }
    }

}

