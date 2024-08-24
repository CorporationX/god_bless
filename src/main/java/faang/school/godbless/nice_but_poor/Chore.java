package faang.school.godbless.nice_but_poor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.printf("%s working with chore: %s%n", currentThreadName, chore);
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.printf("%s with task %s interrupted!%n", currentThreadName, chore);
        }
    }
}
