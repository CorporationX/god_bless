package school.faang.bjs248493;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CountDownLatch;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final CountDownLatch countDownLatch;
    private final int leadTime = 3000;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start task: " + chore);
            Thread.sleep(leadTime);
            System.out.println(Thread.currentThread().getName() + " finish task: " + chore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
