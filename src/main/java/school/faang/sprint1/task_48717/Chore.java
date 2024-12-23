package school.faang.sprint1.task_48717;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Событие");
            Thread.sleep(5000);
            System.out.println(chore + " Ready");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана");
        }

    }
}
