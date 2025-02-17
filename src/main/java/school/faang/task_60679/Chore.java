package school.faang.task_60679;

public class Chore implements Runnable{
    private final String title;

    public Chore(String title) {
        validateTitle(title);
        this.title = title;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + title);
            Thread.sleep(1000);
            System.out.println(title + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + title + " была прервана.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cant be null or blank");
        }
    }
}
