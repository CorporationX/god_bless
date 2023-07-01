package faang.school.godbless;

public class Chore implements Runnable {
    private String taskName;

    public Chore(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " thread | Task start: " + taskName);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " thread | Task finish: " + taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
