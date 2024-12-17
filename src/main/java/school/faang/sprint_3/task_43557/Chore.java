package school.faang.sprint_3.task_43557;

public record Chore(String chore) implements Runnable {
    private static final int SLEEP_TIME = 2000;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет: " + chore);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана...");
        }
        System.out.println("Задача " + chore + " выполнена!");
    }
}
