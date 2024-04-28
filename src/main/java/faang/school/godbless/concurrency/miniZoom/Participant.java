package faang.school.godbless.concurrency.miniZoom;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public record Participant(String name) {
    private static final int TIMEOUT = 60;

    public void joinConference(@NonNull Conference conference) {
        log.info("User " + name + " joined the " + conference.getTheme() + " conference. " +
                "\n(Waiting until min number of participates will be accessed.");

        try {
            conference.getBarrier().await(TIMEOUT, TimeUnit.SECONDS);

            conference.startStreaming(this);
        } catch (InterruptedException | BrokenBarrierException e) {
            log.error("Error was raised during waiting for min number of participants.", e);
        } catch (TimeoutException e) {
            log.warn("Min number wasn't accessed in " + TIMEOUT + " seconds of waiting. Quiting the conference. (" + name + ")");
        }
    }
}
