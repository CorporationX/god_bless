package school.faang.sprint1.task_48261;

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
            System.out.println(name + " начал выполнение задачи - " + task);
            Thread.sleep(5000);
            System.out.println(name + " Завершил задачу");
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи прервано");
        }
    }
}
