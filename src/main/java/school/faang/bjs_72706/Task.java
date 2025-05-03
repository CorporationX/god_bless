package school.faang.bjs_72706;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " начинает выполнение задачи: " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван при выполнении задачи: " + task);
            return;
        }
        System.out.println(name + " завершил выполнение задачи: " + task);
    }
}
