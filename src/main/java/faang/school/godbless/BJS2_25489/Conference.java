package faang.school.godbless.BJS2_25489;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public record Conference(String name, AtomicInteger participantsCounter, CountDownLatch latch) {

    public Conference(String name, int participantsAmount) {
        this(name, new AtomicInteger(0), new CountDownLatch(participantsAmount));
    }

    public void addParticipant(Participant participant) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Participant {} has joined conference", participant.name());
        participantsCounter.incrementAndGet();
        latch.countDown();
    }

    public void startStreaming() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error in thread: {}", e.getMessage());
        }

        log.info("Conference '{}' has started, amount of participants = {}", name, participantsCounter.get());
    }
}
