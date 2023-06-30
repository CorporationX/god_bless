package faang.school.godbless.multithreading.nice_poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String task;

    @Override
    public void run() {
        System.out.printf("Started task - %s (%s)\n", task, Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.printf("Task - %s interrupted\n", task);
            throw new RuntimeException(e);
        }
        System.out.printf("Task - %s done (%s)\n", task, Thread.currentThread().getName());
    }
}
