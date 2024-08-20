package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(chore + " is over");
    }
}
