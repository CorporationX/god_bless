package faang.school.godbless.multithreading.bigbangtheory;

public record Task(String name, String task) implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s by %s is running!\n", task, name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s by %s is interrupted!\n", task, name);
        }
        System.out.printf("%s by %s is finished!\n", task, name);
    }
}
