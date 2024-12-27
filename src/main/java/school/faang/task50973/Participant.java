package school.faang.task50973;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public record Participant(int id,
                          Conference conference) {

    private static final String waitConference = "{} присоеденяется к конференции";

    public void joinConference() {
        CyclicBarrier barrier = conference.getBarrier();
        try {
            if (!barrier.isBroken()) {
                log.info("{} ожидает конференции", this);
                barrier.await();
            }
            log.info(waitConference, this);
        } catch (InterruptedException | BrokenBarrierException e) {
            log.error("Произошла ошибка при входе на конференцию {}", this, e);
            Thread.currentThread().interrupt();
        }
    }
}
