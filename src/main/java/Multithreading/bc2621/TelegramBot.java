package Multithreading.bc2621;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(Message message) throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        long betweenTime = currentTime - lastRequestTime;


        if (betweenTime < 1000) {
            while (requestCounter == REQUEST_LIMIT) {
                System.out.println("Need wait");
                wait(1000 - betweenTime);

                if (System.currentTimeMillis() - lastRequestTime > 1000) {
                    requestCounter = 0;
                    lastRequestTime = System.currentTimeMillis();
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
            System.out.println("I'm here");
        }

        requestCounter++;
        System.out.println(message.getMessage() + " " + requestCounter);
        notify();
    }

}

