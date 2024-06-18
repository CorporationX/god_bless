package faang.school.godbless.theBigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Running " + task);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Task interrupted", e);
        }
    }
}
