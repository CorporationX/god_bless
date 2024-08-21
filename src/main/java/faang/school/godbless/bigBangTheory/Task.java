package faang.school.godbless.bigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " started the " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(name + "was interrupted doing " + task);
        }
        System.out.println(name + " finished the " + task);
    }
}
