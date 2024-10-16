package bjs2_36677;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": " + chore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
