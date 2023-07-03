package faang.school.godbless.Sprint4.task2_Synch;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long lastSegmentTime = currentTime - lastRequestTime;
        if (lastSegmentTime < 1000) {
            requestCounter++;
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - lastSegmentTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
        System.out.println("Message sent: " + message);
    }
}
