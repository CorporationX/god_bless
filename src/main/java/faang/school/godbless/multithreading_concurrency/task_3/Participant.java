package faang.school.godbless.multithreading_concurrency.task_3;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class Participant {
    private final String name;
    private final CyclicBarrier barrier;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int MAX_JOINING_TIME = 4000;

    public void joinConference() {
        try {
            log.info("{} started joining stream", name);
            Thread.sleep(RANDOM.nextInt(MAX_JOINING_TIME));
            log.info("{} joined Stream", name);
            barrier.await();
        } catch (InterruptedException e) {
            log.error("{} was interrupted while joining the stream", name, e);
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            log.error("{} encountered a broken barrier error while joining the stream", name, e);
        }
    }
}
