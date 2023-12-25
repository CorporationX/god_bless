package faang.school.godbless.multithreading_parallelism.they_were_very_nice_but_extremely_poor;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.printf("%s : %s %n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
