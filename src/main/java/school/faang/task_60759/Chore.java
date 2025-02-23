package school.faang.task_60759;

public class Chore implements Runnable {
    private final String title;
    private static final int TASK_DURATION_MS = 5000;

    public Chore(String title) {
        this.title = title;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + title);
            Thread.sleep(TASK_DURATION_MS);
            System.out.println(title + " задача выполнена ");
        } catch (InterruptedException e) {
            System.out.println("задача " + title + " была прервана");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
