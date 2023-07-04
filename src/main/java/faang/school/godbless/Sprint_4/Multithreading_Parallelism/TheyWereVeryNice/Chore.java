package faang.school.godbless.Sprint_4.Multithreading_Parallelism.TheyWereVeryNice;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.printf("Выполняется задача: %s in %s\n", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Задача: %s in %s -- IS COMPLETED\n", chore, Thread.currentThread().getName());
    }
}
