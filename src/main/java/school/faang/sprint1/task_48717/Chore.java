package school.faang.sprint1.task_48717;

public class Chore implements Runnable {
    private final String CHORE;

    public Chore(String CHORE) {
        this.CHORE = CHORE;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Событие");
            Thread.sleep(5000);
            System.out.println(CHORE + " Ready");
        } catch (InterruptedException e) {
            System.out.println("Задача " + CHORE + " прервана");
        }

    }
}
