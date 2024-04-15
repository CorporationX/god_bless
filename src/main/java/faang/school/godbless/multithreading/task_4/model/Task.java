package faang.school.godbless.multithreading.task_4.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s приступил к задаче %s%n", name, task);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.printf("%s было прервано %n", task);
            e.printStackTrace();
            log.error("Task {} was interrupted", task);
        }
    }
}