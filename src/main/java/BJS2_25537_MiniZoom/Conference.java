package BJS2_25537_MiniZoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    private static final int PARTICIPANTS_TO_START = 6;
    private final CyclicBarrier BARRIER = new CyclicBarrier(PARTICIPANTS_TO_START, () -> {
        log.info("All parties connected stream is starting now!");
        startStreaming();
    });

    public void startStreaming() {
        log.info("Stream is on!!! Hello everyone!");
    }

    public void awaitAllToJoin() {
        try {
            BARRIER.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            log.error("Something went wrong!", e);
        }
    }
}
