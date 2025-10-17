package bjs2_89567;

class Task implements Runnable {
    private final String name;
    private final String task;

    private static final long TASK_DURATION_MS = 2000;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s начал выполнение задачи: %s%n", name, task);
            Thread.sleep(TASK_DURATION_MS);
            System.out.printf("%s завершил выполнение задачи: %s%n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("%s прервал выполнение задачи: %s%n", name, task);
            Thread.currentThread().interrupt();
        }
    }
}