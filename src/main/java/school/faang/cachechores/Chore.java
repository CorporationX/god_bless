package school.faang.cachechores;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s starting process for chore: %s", Thread.currentThread().getName(), chore));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
        System.out.println(String.format("%s ending process for chore: %s", Thread.currentThread().getName(), chore));
    }
}

