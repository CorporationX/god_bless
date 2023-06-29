package sprint4.telegram;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TelegramBot {
    private static final int SECOND = 1000;
    private final int requestLimit;
    private long lastRequestTime;
    private int requestCounter;

    public TelegramBot(int requestLimit, long lastRequestTime) {
        this.requestLimit = requestLimit;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) {
        waitIfLimitIsExceeded();
        resetRequestTimeAndCounter();
        requestCounter++;
        System.out.printf("Message sent via Telegram API: %s\n", message);

    }

    private void waitIfLimitIsExceeded() {
        if (requestCounter == requestLimit) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Work interrupted");
            }
        }
    }

    private void resetRequestTimeAndCounter() {
        if ((lastRequestTime - System.currentTimeMillis()) >= SECOND) {
            lastRequestTime = System.currentTimeMillis();
            requestCounter = 0;
        }
    }
}
