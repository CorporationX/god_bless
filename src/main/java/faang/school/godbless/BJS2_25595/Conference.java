package faang.school.godbless.BJS2_25595;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

@Getter
public class Conference {
    private final String title;
    private final int size;
    private final CountDownLatch countDownLatch;

    public Conference(String title, int size) {
        this.title = title;
        this.size = size;
        this.countDownLatch = new CountDownLatch(size);
    }

    public void startStreaming() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("await error");
        }
        System.out.println("Start stream");
    }
}
