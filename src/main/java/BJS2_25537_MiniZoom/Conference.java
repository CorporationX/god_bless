package BJS2_25537_MiniZoom;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Getter
@Setter
@Slf4j
public class Conference implements Runnable {
    private static final int PARTICIPANTS_TO_START = 6;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(PARTICIPANTS_TO_START, () -> {
        log.info("All parties connected stream is starting now!");
        new Conference().startStreaming();
    });

    public void startStreaming() {
        log.info("Stream is on!!! Hello everyone!");
    }

    @Override
    public void run() {
        try {
            BARRIER.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            log.error("Something went wrong!", e);
        }
    }
}
