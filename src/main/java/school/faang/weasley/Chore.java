package school.faang.weasley;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println("Задача: " + chore + ", Поток: " + Thread.currentThread().getName());
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
    }
}
