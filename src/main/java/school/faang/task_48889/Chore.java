package school.faang.task_48889;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил задачу " + chore);
        } catch (InterruptedException e) {
            System.err.println("Задача была прервана: " + chore);
        }

    }
}
