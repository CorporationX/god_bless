package school.faang.task_48266;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    private static final int TASK_EXECUTION_TIME_MS = 1000;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        try {
            Thread.sleep(TASK_EXECUTION_TIME_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(Thread.currentThread().getName() + " был прерван при выполнении задачи: " + chore);
        }
        System.out.println(Thread.currentThread().getName() + " завершил задачу: " + chore);
    }
}
