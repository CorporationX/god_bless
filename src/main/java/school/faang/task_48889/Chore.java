package school.faang.task_48889;

public class Chore implements Runnable {
    private static final int SLEEP_TIME_MS = 1000;
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
            Thread.sleep(SLEEP_TIME_MS);
            System.out.println(Thread.currentThread().getName() + " завершил задачу " + chore);
        } catch (InterruptedException e) {
            System.err.println("Задача была прервана: " + chore);
        }

    }
}
