package faang.school.godbless.multithreading.telegram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import lombok.Getter;

@Getter
public class TelegramBot {
    private final static int REQUEST_LIMIT = 5;
    private final static int INTERVAL = 1000;
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public void sendMessage(String message) {
        synchronized (this) {
            LocalDateTime currentTime = LocalDateTime.now();
            long diff = getTimeDiff(currentTime);

            if (diff < INTERVAL) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    try {
                        wait(INTERVAL - diff);
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }
            } else {
                requestCounter = 0;
                lastRequestTime = currentTime;
            }

            System.out.printf("%s sent at %s\n", message, currentTime.format(FORMATTER));
            notifyAll();
        }
    }

    private long getTimeDiff(LocalDateTime currentTime) {
        return currentTime.get(ChronoField.MILLI_OF_DAY) - lastRequestTime.get(ChronoField.MILLI_OF_DAY);
    }
}
