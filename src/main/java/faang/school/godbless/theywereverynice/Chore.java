package faang.school.godbless.theywereverynice;

public record Chore(String chore) implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Task name: " + chore + " are started");
        try {
            System.out.println("Task: " + chore + " in progress...");
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task: " + chore + " is terminated!");
    }
}
