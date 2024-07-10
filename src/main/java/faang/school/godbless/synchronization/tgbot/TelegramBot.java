package faang.school.godbless.synchronization.tgbot;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int MAX_NANO_VALUE = 999_999_999;
    private static final int NANO_IN_MILLI = 1_000_000;
    private int requestCounter;
    private Instant startLimitTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.startLimitTime = Instant.EPOCH;
    }

    public void sendMessage(String message) throws InterruptedException {
        synchronized (this) {
            log.debug(String.format("Sending message [%s]", message));
            Instant now = Instant.now();
            Instant difference = now.minusSeconds(startLimitTime.getEpochSecond())
                    .minusNanos(startLimitTime.getNano());
            if (difference.getEpochSecond() >= 1) {
                requestCounter = 1;
                startLimitTime = now;
            } else {
                requestCounter++;
                if (requestCounter >= REQUEST_LIMIT) {
                    int nanosToWait = MAX_NANO_VALUE - difference.getNano();
                    int millisToWait = nanosToWait / NANO_IN_MILLI;
                    int nanosRemainder = nanosToWait % NANO_IN_MILLI;

                    log.debug("Too much messages sent in 1sec, sleeping");
                    Thread.sleep(millisToWait, nanosRemainder);
                }
            }
            log.debug(String.format("Message [%s] sent", message));
        }
        MockApiTelegram.sendMessage(message);
    }
}
