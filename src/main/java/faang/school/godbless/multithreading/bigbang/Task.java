package faang.school.godbless.multithreading.bigbang;

public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("Начало выполнения задачния - " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Задача была прервана");
        }
        System.out.println("Окончание выполнения задания - " + name);

    }
}
