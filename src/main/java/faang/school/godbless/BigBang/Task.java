package faang.school.godbless.BigBang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " starting task: " + task);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep is interruptd!");
        }
    }
}
