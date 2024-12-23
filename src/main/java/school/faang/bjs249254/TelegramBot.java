package school.faang.bjs249254;

import static java.lang.System.currentTimeMillis;

public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.lastRequestTime = currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long start = System.currentTimeMillis();
        long timeElapsed = start - lastRequestTime;
        try {
            if (timeElapsed < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                    message += " was in waiting block";
                }
            } else {
                requestCounter = 0;
                lastRequestTime = start;
                notifyAll();
                message += " was in notifyAll block";
            }
            System.out.printf("%s .Message sent: %s\n", Thread.currentThread().getName(), message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
