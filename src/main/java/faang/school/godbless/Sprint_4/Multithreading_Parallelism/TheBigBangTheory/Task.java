package faang.school.godbless.Sprint_4.Multithreading_Parallelism.TheBigBangTheory;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("%s now doing %s\n", name, task);
        try {
            Thread.sleep(4000);
            System.out.printf("Task %s by %s is completed\n", task, name);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

    }
}
