package faang.school.godbless.sprint.three.cachedthread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.printf("Start '%s' in thread '%s'%n", this.chore, Thread.currentThread().getName());
        try {
            Thread.sleep(Constants.CHORE_DURATION);
            System.out.printf("Finish '%s' thread '%s'%n", this.chore, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
