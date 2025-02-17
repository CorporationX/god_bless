package school.faang.bjs2_60463;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    private final CountDownLatch countDownLatch;

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append("Letter ").append(i).append(" has been sent.\n");
        }
        System.out.print(sb.toString());
        countDownLatch.countDown();
    }
}
