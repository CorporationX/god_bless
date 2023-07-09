package faang.school.godbless.Sprint4.task2_Synch;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    public synchronized void sendMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        long timeElapsed = ChronoUnit.MILLIS.between(lastRequestTime, currentTime);

        if (timeElapsed < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                System.out.println(Thread.currentThread().getName() + " is waiting");
                try {
                    Thread.sleep(1000 - timeElapsed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            requestCounter = 2;
            lastRequestTime = currentTime;
        }

        System.out.println("Message sent: " + message);
    }
}
