package school.faangSprint3.t13;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " начал выполнение задачи: " + task);
            Thread.sleep(2000);
            System.out.println(name + " завершил выполнение задачи: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " прервал выполнение задачи: " + task);
            Thread.currentThread().interrupt();
        }
    }
}