package faang.school.godbless.multithreading.parallelism_thread.bigbang;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + name + " начинает выполнять задание " + task);
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            System.out.println("Задача была прервана из за ошибки");
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " " + name + " закончил выполнять задание " + task);
    }
}
