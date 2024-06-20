package faang.school.godbless.the_big_bang_theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("The task started to run");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Task execution was interrupted");
        }
        System.out.println("The task ended to run");
    }
}
