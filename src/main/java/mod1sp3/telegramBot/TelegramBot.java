package mod1sp3.telegramBot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int REQUEST_TIME_LIMIT = 1000;
    private int requestCounter = 0;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        this.lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        long timeDifferenceBetweenLastMessage = Math.abs(ChronoUnit.MILLIS.between(LocalDateTime.now(), lastRequestTime));
        System.out.println("Request counter: " + requestCounter);
        if (timeDifferenceBetweenLastMessage < REQUEST_TIME_LIMIT) {
            requestCounter++;
        } else {
            requestCounter = 0;
        }
        if (requestCounter >= REQUEST_LIMIT) {
            try {
                System.out.println("Превышен лимит операций в секунду! Повторите через 10 секунд!");
                this.wait(10000);
                requestCounter = 0;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
        System.out.println("Сообщение <" + message + "> отправлено, разница отправки с предыдущим - " + timeDifferenceBetweenLastMessage);
        lastRequestTime = LocalDateTime.now();
    }
}
