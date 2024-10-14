package school.faang.goodandbad;

public record Chore(String chore) implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача выполнена потоком: " + Thread.currentThread().getName());
    }
}
