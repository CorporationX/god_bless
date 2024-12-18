package school.faang.task_49206;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;
    private static final int MSECONDS_LIMIT = 1000;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        while (true) {
            long lastRequestBeforeNow = System.currentTimeMillis() - lastRequestTime;

            if (lastRequestBeforeNow < MSECONDS_LIMIT) {
                requestCounter++;
            } else {
                System.out.println("->");
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
            }

            if (requestCounter > REQUEST_LIMIT) {
                wait(3000);
                continue;
            }

            System.out.println("Sending message : " + message);
            break;
        }
    }
}
