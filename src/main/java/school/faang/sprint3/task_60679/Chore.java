package school.faang.sprint3.task_60679;

public class Chore implements Runnable {
    private static final int TASK_DURATION_MS = 1000;
    private final String title;

    public Chore(String title) {
        validateTitle(title);
        this.title = title;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + title);
            Thread.sleep(TASK_DURATION_MS);
            System.out.println(title + " выполнена!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Задача " + title + " была прервана.");
        }
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cant be null or blank");
        }
    }
}
