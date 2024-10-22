package school.faang.sprint_3.bjs2_37266_telegramBot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeDelta = currentTime - lastRequestTime;

        if (timeDelta < 1000) {
            requestCounter++;
            log.info("{}", requestCounter);
            if (requestCounter >= REQUEST_LIMIT) {
                log.info("Request counter is over the limit, waiting for {} ms", 1000 - timeDelta);
                try {
                    Thread.sleep(1000 - timeDelta);
                } catch (InterruptedException e) {
                    log.error("An error occurred while sleeping", e);
                    throw new IllegalStateException(e);
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = System.currentTimeMillis();
        }

        log.info("SENDING MESSAGE {}", message);
    }
}