package faang.school.godbless.thread5;

public record Chore(String chore) implements Runnable {
    private static final String ERROR = "Задача прервана: ";
    private static final String MESSAGE_TASK_STARTED = "Задача %s выполняется - %s\n";
    private static final String MESSAGE_TASK_DONE = "Задача %s выполнена\n";

    @Override
    public void run() {
        System.out.format(MESSAGE_TASK_STARTED, chore, Thread.currentThread().getName());
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
        System.out.format(MESSAGE_TASK_DONE, chore);

    }
}
