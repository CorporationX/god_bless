package school.faang.multythreading.weasley;

public record Chore (String chore) implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + chore);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
