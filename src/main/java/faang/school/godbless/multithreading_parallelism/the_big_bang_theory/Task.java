package faang.school.godbless.multithreading_parallelism.the_big_bang_theory;

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
            System.out.println(name + " начал выполнение задания: " + task);
            Thread.sleep(1000);
            System.out.println(name + " завершил выполнение задания: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван во время выполнения задания: " + task);
        }
    }
}
