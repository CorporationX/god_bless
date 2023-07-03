package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

public class Chore implements Runnable{
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(chore + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
