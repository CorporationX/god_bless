package theyWereVeryNice;

public class Chore implements Runnable {
    private String chore;

    public Chore(String choreName) {
        this.chore = choreName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            System.out.println("Задача " + chore + " выполнена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
