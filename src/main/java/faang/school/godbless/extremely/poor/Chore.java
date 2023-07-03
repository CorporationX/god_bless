package faang.school.godbless.extremely.poor;

public class Chore implements Runnable {
    private java.lang.String chore;

    public Chore(java.lang.String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начат");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " закончен");
    }
}
