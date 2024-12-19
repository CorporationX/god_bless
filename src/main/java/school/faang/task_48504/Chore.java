package school.faang.task_48504;


public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public String toString() {
        return "\t Задача: " + chore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Поток: " + Thread.currentThread().getName() + this.chore);
        } catch (InterruptedException e) {
            System.out.println("Задача " + this.chore + " прервалась!!!");
        }

    }
}
