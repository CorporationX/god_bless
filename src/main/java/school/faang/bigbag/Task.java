package school.faang.bigbag;

public record Task(String name, String task) implements Runnable {
    @Override
    public void run() {
        System.out.println("Start task");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка при вызове: Thread.sleep(1000)", e);
        }
    }
}
