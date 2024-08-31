package faang.school.godbless.bigbangtheory;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " начинает выполнение задания: " + task);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(name + " прервано во время выполнения задания.");
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println(name + " завершил выполнение задания: " + task);
    }
}
