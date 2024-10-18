package school.faang.telegrambot;

import java.time.Duration;
import java.time.LocalDateTime;

class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(lastRequestTime, currentTime);

        if (duration.toMillis() < 1000) {
            requestCounter++;
        } else {
            requestCounter = 1;
            lastRequestTime = currentTime;
        }

        if (requestCounter > REQUEST_LIMIT) {
            long waitTime = 1000 - duration.toMillis();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread hes been interrupted " + e);
            }

            requestCounter = 1;
            lastRequestTime = LocalDateTime.now();
        }

        System.out.println("Сообщение отправлено: " + message);
    }
}
