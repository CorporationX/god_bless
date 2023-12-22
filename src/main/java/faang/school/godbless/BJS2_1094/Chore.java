package faang.school.godbless.BJS2_1094;

public class Chore implements Runnable {
    private String task;

    public Chore(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        String output = "The task \"" + this.task + "\" %s in thread \"" + Thread.currentThread().getName() + "\"\n";

        System.out.printf(output, "started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf(output, "interrupted");
        }
        System.out.printf(output, "finished");
    }
}