package faang.school.godbless.BJS224529;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(int requestLimit) {
        this.REQUEST_LIMIT = requestLimit;
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        long timeSinceLastRequest = currentTime - lastRequestTime;

        if (timeSinceLastRequest < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                System.out.println(Thread.currentThread().getName() + ": Request limit reached. Waiting for 1 second");
                wait(1000 - timeSinceLastRequest);
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
            }
        } else {
            requestCounter = 1;
            lastRequestTime = currentTime;
        }

        System.out.println(Thread.currentThread().getName() + ": " + message);
        notifyAll();
    }
}
