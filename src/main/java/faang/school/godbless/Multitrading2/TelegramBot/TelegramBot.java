package faang.school.godbless.Multitrading2.TelegramBot;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.lastRequestTime = System.currentTimeMillis();
        this.requestCounter = 0;
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long leftTime = currentTime - lastRequestTime;
        if (leftTime < 5000) {
            while (requestCounter == REQUEST_LIMIT) {
                try {
                    System.out.println("Pause is required");
                    wait(5000 - leftTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (System.currentTimeMillis() - lastRequestTime > 5000) {
                    requestCounter = 0;
                    lastRequestTime = System.currentTimeMillis();
                }
            }
            System.out.println(Thread.currentThread().getName() + " requestCounter = " + requestCounter);
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
        requestCounter++;
        System.out.println("Send message: " + message + requestCounter);
        notify();
    }
}
