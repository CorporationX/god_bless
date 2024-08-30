package zoom;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Participant {
    private static final long TIME_OUT = 1L;
    private final String name;

    public void joinConference(@NonNull Conference conference) {
        log.info("{} joined conference", name);
        try {
            conference.getBarrier().await(TIME_OUT, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (BrokenBarrierException | TimeoutException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
