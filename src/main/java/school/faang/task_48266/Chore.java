package school.faang.task_48266;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил задачу: " + chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(Thread.currentThread().getName() + " был прерван при выполнении задачи: " + chore);
        }
    }
}
