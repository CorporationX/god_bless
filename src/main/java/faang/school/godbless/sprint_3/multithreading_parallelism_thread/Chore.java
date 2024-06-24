package faang.school.godbless.sprint_3.multithreading_parallelism_thread;

public record Chore(String chore) implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("Работает: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
