package Multithreading.bc2621;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelegramBot implements Runnable {
    private static final int REQUEST_LIMIT = 5;
    private Message message;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(Message message, long lastRequestTime) {
        this.message = message;
        this.requestCounter = 0;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(Message message) throws InterruptedException {

        long last = lastRequestTime;
        long betweenTime = System.currentTimeMillis() - last;
        System.out.println(betweenTime);
        if (betweenTime < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                wait(1000 - betweenTime);
                requestCounter = 0;
            }
        } else {
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
            System.out.println("I'm here");
        }
        notifyAll();
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

