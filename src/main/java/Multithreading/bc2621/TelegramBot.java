package Multithreading.bc2621;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TelegramBot implements Runnable {
    private static final int REQUEST_LIMIT = 5;
    private Message message;
    private int requestCounter;
    private long lastRequestTime;


    public synchronized void sendMessage(Message message) throws InterruptedException {

        long last = lastRequestTime;
        long betweenTime = System.currentTimeMillis() - last;

        if (betweenTime < 1000) {
            requestCounter++;
            if (getRequestCounter() > REQUEST_LIMIT) {
                wait(1000 - betweenTime);
            }
        } else {
            requestCounter = 0;
            lastRequestTime = 0;
            notify();
        }
        System.out.println(message.getMessage());
    }

    @Override
    public void run() {
        try {
            sendMessage(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

