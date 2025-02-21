package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private static final int TIME_LIMIT_MS = 1000;
    private static final int FIRST_REQUEST = 1;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - lastRequestTime;
        if (timeDifference < TIME_LIMIT_MS) {
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    wait(TIME_LIMIT_MS - timeDifference);
                    requestCounter = 0;
                    lastRequestTime = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    log.error("Поток был перван во время ожидания окончания лимита отправки сообщений: ", e);
                    throw new RuntimeException(e);
                }
            }
            requestCounter++;
        } else {
            requestCounter = FIRST_REQUEST;
            notifyAll();
        }
        lastRequestTime = System.currentTimeMillis();
        log.info("Сообщение отправлено с текстом: {}", message);
    }
}
