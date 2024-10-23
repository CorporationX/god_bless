package school.faang.sprint3.extremelypoor;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
       try {
           System.out.println(Thread.currentThread().getName()+" выполняет задачу: " + chore);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
