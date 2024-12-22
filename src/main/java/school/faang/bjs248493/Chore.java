package school.faang.bjs248493;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CountDownLatch;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final CountDownLatch countDownLatch;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start task: " + chore);
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " finish task: " + chore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
