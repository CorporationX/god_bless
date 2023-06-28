package Sprint_4_Task14;

import java.time.LocalDateTime;

public class TelegramBot {
    private int REQUEST_LIMIT ;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT, LocalDateTime lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }
    public void sendMessage(String message) {
        requestCounter++;
        if (requestCounter > REQUEST_LIMIT) {
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
        }else if ()
    }
}
