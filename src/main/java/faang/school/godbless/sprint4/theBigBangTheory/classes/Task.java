package faang.school.godbless.sprint4.theBigBangTheory.classes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " doing " + task);
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            System.out.println("Somebody interrupted me");
        }
        System.out.println(name + " did " + task);
    }
}