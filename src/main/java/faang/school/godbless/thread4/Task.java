package faang.school.godbless.thread4;

public record Task(String name, String task) implements Runnable {
    private static final String ERROR = "Задача прервалась: ";
    private static final long TASK_COMPLETION_TIME = 1000L;
    private static final String MESSAGE_TASK_STARTED = "%s: Начал выполнять задачу - %s \n";
    private static final String MESSAGE_TASK_DONE = "%s: Задача %s выполнена \n";

    @Override
    public void run() {
        System.out.format(MESSAGE_TASK_STARTED, name, task);
        try {
            Thread.sleep(TASK_COMPLETION_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
        System.out.format(MESSAGE_TASK_DONE, name, task);
    }
}
