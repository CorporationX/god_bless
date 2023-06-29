package faang.school.godbless.sprint4.multithreading_parallelism_thread.task6;

public class Task implements Runnable {

    private String name;

    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " начал выполнять задание " + task);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Задание " + task + " прервано");
            throw new RuntimeException(e);
        }
    }
}
