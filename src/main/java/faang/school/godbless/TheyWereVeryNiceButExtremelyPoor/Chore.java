package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": " + chore + " - done");
    }
}