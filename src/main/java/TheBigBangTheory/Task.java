package TheBigBangTheory;

public class Task implements Runnable {

    private final String nameTask;

    public Task(String nameTask) {
        this.nameTask = nameTask;
    }

    @Override
    public void run() {
        System.out.println("Starting execute task " + nameTask);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + nameTask + " прервана!");
        }
        System.out.println("Task " + nameTask + " complete");
    }
}
