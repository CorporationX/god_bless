package faang.school.godbless.theyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
