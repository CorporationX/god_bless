package faang.school.godbless.BJS2_25710;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Conference {
    private CountDownLatch countDownLatch;

    public Conference(int requiredQuantityParticipants) {
        countDownLatch = new CountDownLatch(requiredQuantityParticipants);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> startStreaming(executor));
    }

    public void joinConference(Participant participant) {
        System.out.println("Joining conference: " + participant.getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        countDownLatch.countDown();
    }

    private void startStreaming(ExecutorService executor) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executor.shutdownNow();
        System.out.println("Starting streaming...");
    }
}
