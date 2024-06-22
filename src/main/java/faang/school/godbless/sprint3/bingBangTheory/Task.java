package faang.school.godbless.sprint3.bingBangTheory;

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
            System.out.println(name + " Start doing task " + task);
            Thread.sleep(2000);
            System.out.println(name + " has done task " + task);
        } catch (InterruptedException e) {
            System.out.println("The task is closed by reason: " + e.getMessage());
        }
    }
}
