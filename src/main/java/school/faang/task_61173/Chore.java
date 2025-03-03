package school.faang.task_61173;

public class Chore implements Runnable {

    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " implements task: " + chore);
            Thread.sleep(1000);
            System.out.println("The task of " + chore + " is complete!");
        } catch (InterruptedException e) {
            System.out.println("The task " + chore + " was interrupted.");
        }
    }
}
