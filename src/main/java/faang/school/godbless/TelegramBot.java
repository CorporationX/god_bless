package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private Date lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = new Date();
    }

    public synchronized void sendMessage(String message) {
        Date currentTime = new Date();
        long timeElapsed = currentTime.getTime() - lastRequestTime.getTime();

        if (timeElapsed < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - timeElapsed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                requestCounter = 1;
            }
        }
        System.out.println("Send message: " + message);

        lastRequestTime = new Date();
    }
}
