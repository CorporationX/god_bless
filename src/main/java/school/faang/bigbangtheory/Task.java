package school.faang.bigbangtheory;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " начал выполнять задачу " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
        System.out.println(name + " закончил выполнять задачу " + task);
    }
}
