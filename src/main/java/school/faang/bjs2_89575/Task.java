package school.faang.bjs2_89575;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    public static final int TASK_EXECUTION_TIME = 5;
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s начинает выполнять задачу - %s.%n", name, task);
            Thread.sleep(TASK_EXECUTION_TIME * 1000);
            System.out.printf("Задача %s выполнена.%n", task);
        } catch (InterruptedException e) {
            System.out.printf("Выполнение задачи %s прервано.", task);
            throw new RuntimeException(e);
        }
    }
}
