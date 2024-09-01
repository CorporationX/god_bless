package faang.school.godbless.BJS2_24403;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int REQUESTS_IN_TIME = 1000;
    private int requestCounter;
    private long lastRequestTime;

    public synchronized void sendMessage(String message) {

        if (calculateTimeDiff() >= REQUESTS_IN_TIME) {
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
        }

        if (requestCounter < REQUEST_LIMIT) {
            requestCounter++;
            System.out.println("The message " + message + " has been sent");
        } else {
            try {
                wait(REQUESTS_IN_TIME - calculateTimeDiff());
                sendMessage(message);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    private long calculateTimeDiff() {
        return System.currentTimeMillis() - lastRequestTime;
    }

}
