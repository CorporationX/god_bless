package faang.school.godbless.BigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " has started: " + task);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(task + " has been interrupted");
        }

        System.out.println(name + " has ended: " + task);
    }
}
