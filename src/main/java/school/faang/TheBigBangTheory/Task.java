package school.faang.TheBigBangTheory;

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
            System.out.println("Start" + name + "task" + task);
            Thread.sleep(1000); // Задержка в 1 секунду
            System.out.println("Start" + name + "task" + task);
        } catch (InterruptedException e) {
            System.out.println("Task" + task + name + "interrupted");
            Thread.currentThread().interrupt();
        }

    }
}
