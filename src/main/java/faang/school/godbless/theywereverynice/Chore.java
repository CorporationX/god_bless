package faang.school.godbless.theywereverynice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("%s is doing task '%s'\n", Thread.currentThread().getName(), chore);
            Thread.sleep(2000L);
            System.out.printf("%s finished task '%s'\n", Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted doing task '%s'\n", Thread.currentThread().getName(), chore);
            Thread.currentThread().interrupt();
        }
    }
}