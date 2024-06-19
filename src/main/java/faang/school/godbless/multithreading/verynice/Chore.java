package faang.school.godbless.multithreading.verynice;

public record Chore(String name) implements Runnable {
    @Override
    public void run() {
        var threadName = Thread.currentThread().getName();
        System.out.printf("Task: %s is being executed by %s%n", name, threadName);

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Task: %s was interrupted!%n", name);
            return;
        }

        System.out.printf("Task: %s is completed by %s%n", name, threadName);
    }
}
