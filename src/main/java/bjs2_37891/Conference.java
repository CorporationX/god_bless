package bjs2_37891;

import java.util.concurrent.CountDownLatch;

public class Conference {
    private final CountDownLatch latch;

    public Conference(int requiredParticipants) {
        latch = new CountDownLatch(requiredParticipants);
    }

    public void startStreaming() throws InterruptedException {
        latch.await();
        System.out.println("Started stream");
    }

    public void addParticipant() throws InterruptedException {
        latch.countDown();
        latch.await();
    }
}
