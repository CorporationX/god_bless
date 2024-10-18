package school.faang.m1s3.bjs2_37213_telegram;

import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;

@NoArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;

    private final Object lockMessage = new Object();
    private final Object lockCounter = new Object();
    private int request_counter = 0;
    private LocalTime lastRequestTime = LocalTime.now();

    public void sendMessage(String message) {
        synchronized (lockMessage) {
            while (request_counter > REQUEST_LIMIT) {
                try {
                    lockMessage.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
                }
            }
            synchronized (lockCounter) {
                request_counter++;
                System.out.println("id#" + Thread.currentThread().getId() + " " + LocalTime.now() + " " + message + " sent");
                System.out.println(Duration.between(lastRequestTime, LocalTime.now()));
                lastRequestTime = LocalTime.now();
            }
            resetCounter();
        }
    }

    private void resetCounter() {
        while (request_counter > 0) {
            synchronized (lockCounter) {
                waitBetweenRequests();
                request_counter--;
                lockMessage.notifyAll();
            }
        }
    }

    private void waitBetweenRequests() {
        try {
            Thread.sleep(1000 / REQUEST_LIMIT);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}



