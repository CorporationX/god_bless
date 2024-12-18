package school.faang.task_48417;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(2000);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
        }
    }
}

