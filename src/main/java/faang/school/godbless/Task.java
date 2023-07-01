package faang.school.godbless;

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
            System.out.println(Thread.currentThread().getName() + " thread | " + name + " start resolving task " + task);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " thread | " + name + " finish resolving task " + task);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " thread | " + name + " interrupted in resolving task " + task);
        }
    }
}
