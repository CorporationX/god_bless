package faang.school.godbless.thread4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private static final String ERROR = "Задача прервалась: ";
    private static final long TASK_COMPLETION_TIME = 1000L;
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.format("%s: Начал выполнять задачу - %s \n", name, task);
        try {
            Thread.sleep(TASK_COMPLETION_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
        System.out.format("%s: Задача %s выполнена \n", name, task);
    }
}
