package school.faang.sprint3.wisleyfamily;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " working on " + chore);
            Thread.sleep(1000);
            System.out.println("Task " + chore + " is done");
        } catch (InterruptedException e) {
            System.out.println("Task was interrupted");
        }
    }
}
