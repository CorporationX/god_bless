package faang.school.godbless.zoom;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Conference {

    private final int MIN_NUMBER_PARTICIPANTS = 10;

    private final AtomicInteger numParticipants = new AtomicInteger(0);
    private final AtomicBoolean isStreamStarted = new AtomicBoolean(false);

    private final CyclicBarrier BARRIER = new CyclicBarrier(MIN_NUMBER_PARTICIPANTS, this::startStreaming);

    public void startStreaming() {
        if (!isStreamStarted.get()) {
            System.out.println("Start streaming");
            printNumberParticipants();
            isStreamStarted.set(true);
        }
    }

    public void connectToConference() {
        numParticipants.addAndGet(1);
        try {
            BARRIER.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public void printNumberParticipants() {
        System.out.println("Number of participants " + numParticipants);
    }
}
