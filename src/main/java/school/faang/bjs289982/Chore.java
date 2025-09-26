package school.faang.bjs289982;

public class Chore implements Runnable {
    public static final int MILLIS = 10;
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println("Chore [" + chore + "] is being done by " + Thread.currentThread().getName());

        try {
            Thread.sleep(MILLIS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
