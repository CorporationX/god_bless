package school.faang.BJS2_61505;

import lombok.NonNull;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TelegramBot {

    private static final int TIME_AFTER_LAST_REQUEST_MIL_SEC = 1000;
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalTime.now();
    }

    public synchronized void sendMessage(@NonNull String message) {
        LocalTime timeNow = LocalTime.now();
        long ms = Duration.between(lastRequestTime, timeNow).toMillis();

        if (ms < TIME_AFTER_LAST_REQUEST_MIL_SEC) {
            if (requestCounter > REQUEST_LIMIT) {
                long delay = TIME_AFTER_LAST_REQUEST_MIL_SEC - timeNow.getNano() / 1_000_000;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupt exception is released: %s".formatted(e.getMessage()));
                }
                requestCounter = 0;
            } else {
                requestCounter++;
            }
        } else {
            requestCounter = 0;
            lastRequestTime = LocalTime.now();
        }

        String strTime = timeNow.format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS"));
        System.out.println("Sending message, time: %s, message: %s".formatted(strTime, message));
    }
}
