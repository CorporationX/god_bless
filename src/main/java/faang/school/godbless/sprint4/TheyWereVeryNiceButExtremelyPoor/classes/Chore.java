package faang.school.godbless.sprint4.TheyWereVeryNiceButExtremelyPoor.classes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " doing " + chore);

        try {
            Thread.sleep(1_500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName + " done " + chore);
    }
}
