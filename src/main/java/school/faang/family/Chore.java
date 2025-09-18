package school.faang.family;

public class Chore implements Runnable {

    private String task;
    private final int SLEEPING_TIME = 1000;

    public Chore(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + task);
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
