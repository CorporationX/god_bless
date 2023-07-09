package Sprint_4_Telegram_bot;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class TelegramBot {
    private final static int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(long lastRequestTime) {
        this.requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }

    @SneakyThrows
    public void sendMessage(String message) {

        synchronized (this) {
            long currentTime = System.currentTimeMillis();
            long timeDifference = currentTime - lastRequestTime;
            if (timeDifference < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    Thread.sleep(1500 - timeDifference);
                    requestCounter = 1;
                }
                System.out.println(requestCounter);
            } else {
                requestCounter = 1;
            }
            lastRequestTime = System.currentTimeMillis();
            System.out.println("Отправлено сообщение через API Telegram");
        }
    }
//            LocalDateTime currentTime LocalDateTime.now();
//            getLastRequestTime();
//            LocalDateTime timeDifference = currentTime - lastRequestTime;
}
