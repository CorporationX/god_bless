package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private Instant lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = Instant.now();
    }

    public synchronized void sendMessage(String message) {
        Instant currentTime = Instant.now();
        long timeElapsed = currentTime.toEpochMilli() - lastRequestTime.toEpochMilli();

        if (timeElapsed < 1000) {
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - timeElapsed);
                } catch (InterruptedException ex) {
                    System.err.println("Thread sleep interrupted again: " + ex.getMessage());
                    ex.printStackTrace();
                }
                requestCounter = 1;
            }
        } else {
            requestCounter = 0;  // Сбрасываем счетчик при новом временном интервале
        }
        System.out.println("Send message: " + message);
        requestCounter++;
        lastRequestTime = Instant.now();
    }
}
