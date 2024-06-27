package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_5_chore;

public record Chore(String chore) implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("Работает: " + Thread.currentThread().getName());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
