package school.faang.bigbangtheory.maincode;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    public void run() {
        try {
            System.out.println(name + " Начало выполнения задачи " + task);
            Thread.sleep(2000);
            System.out.println(name + " Завершил выполнение задачи " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " прервал выполнение задачи: " + task);
        }
    }
}
