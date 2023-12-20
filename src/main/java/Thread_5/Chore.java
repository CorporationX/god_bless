package Thread_5;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread " + Thread.currentThread().getName() + " complete");
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " dropped");
        }
    }

    public String getChore() {
        return chore;
    }
}
