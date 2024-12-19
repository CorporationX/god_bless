package school.faang.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Task implements Runnable {
    public static final int SLEEP_TIME = 3000;

    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.printf("\"%s\" начал выполнение задачи \"%s\"! \n", name, task);
            Thread.sleep(SLEEP_TIME);
            System.out.printf("\"%s\" завершил выполнение задачи \"%s\"! \n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("Task \"%s\" прервал выполнение задачи \"%s\" :( \n", name, task);

        }
    }
}
