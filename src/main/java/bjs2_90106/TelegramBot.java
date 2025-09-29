package bjs2_90106;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int REQUEST_TIME_LIMIT_MS = 1000;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;

        try {
            if (timeElapsed < REQUEST_TIME_LIMIT_MS) {
                requestCounter++;

                if (requestCounter > REQUEST_LIMIT) {
                    long waitTime = REQUEST_TIME_LIMIT_MS - timeElapsed;
                    System.out.printf("%s ждёт %d мс%n", Thread.currentThread().getName(), waitTime);
                    wait(waitTime);
                    requestCounter = 1;
                    lastRequestTime = System.currentTimeMillis();
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }

            System.out.printf("%s отправил: %s%n", Thread.currentThread().getName(), message);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток был прерван!");
        }
    }
}