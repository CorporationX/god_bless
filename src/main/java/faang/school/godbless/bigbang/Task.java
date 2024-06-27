package faang.school.godbless.bigbang;

public record Task(String name, String task) implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + name + " Starting task " + task);
        try {
            Thread.sleep(2000L);
            System.out.println(task + " in process...");
        } catch (InterruptedException e) {
            System.out.println(task + " is interrupted!");
        }
        System.out.println(task + " is done.");
    }
}
