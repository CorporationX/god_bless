package school.faang.sprint_3.task_48514;

public class Chore implements Runnable {
    private static final int SLEEP_MILLISECONDS = 2000;

    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println("Поток " + threadName + " выполняет задачу: " + chore);
            Thread.sleep(SLEEP_MILLISECONDS);
            System.out.println("Поток " + threadName + " закончил задачу: " + chore);
        } catch (InterruptedException e) {
            System.out.println("У потока " + threadName + " была прервана задача " + chore);
        }
    }
}
