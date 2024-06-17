package faang.school.godbless.TheBigBangTheory;

public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.name + " начал выполнять " + this.task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " " + this.name + " завершил задачу " + this.task);
    }
}
