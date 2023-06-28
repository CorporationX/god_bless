package faang.school.godbless.big_bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String executor;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started doing task - %s (%s)\n", executor, task, Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.printf("%s - %s interrupted (%s)\n", executor, task, Thread.currentThread().getName());
            throw new RuntimeException();
        }
        System.out.printf("%s finished (%s)\n", executor, Thread.currentThread().getName());
    }
}
