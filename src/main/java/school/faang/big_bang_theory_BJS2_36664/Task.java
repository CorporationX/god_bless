package school.faang.big_bang_theory_BJS2_36664;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s has started executing task - %s\n", name, task);
        try {
            final int SLEEP_TIME = 2000;
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException("Task interrupted", e);
        }
        System.out.printf("%s finished executing task - %s\n", name, task);
    }
}
