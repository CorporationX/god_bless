package faang.school.godbless.multithreading.king_landing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("Knight %s begins the trial - %s (%s)\n",
                knightName, trialName, Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Knight %s completed the trial - %s (%s)\n",
                knightName, trialName, Thread.currentThread().getName());
    }
}
