package school.faang.task_48732;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " занят задачей " + chore);
            Thread.sleep(1000);
            System.out.println("Задача " + chore + " выполнена");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " не взята в работу");
        }
    }
}
