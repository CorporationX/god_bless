package school.faang.sprint_3.task_48846;

public class Chore implements Runnable {
    private static final int SLEEP_TIME = 5000;
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Поток " + Thread.currentThread().getName() + " выполнят задачу " + chore);
            Thread.sleep(SLEEP_TIME);
            System.out.println("Задача " + chore + " завершена.");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана ");
        }
    }
}
