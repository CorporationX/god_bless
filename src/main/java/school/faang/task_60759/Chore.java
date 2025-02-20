package school.faang.task_60759;

public class Chore implements Runnable {
    private final String title;

    public Chore(String title) {
        this.title = title;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + title);
            Thread.sleep(5000);
            System.out.println(title + " задача выполнена ");
        } catch (InterruptedException e) {
            System.out.println("задача " + title + "была прервана");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
