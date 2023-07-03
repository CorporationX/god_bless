package faang.school.godbless.spring_4.telegram_bot;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(int requestCounter, long lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(String message) throws InterruptedException {
        long nextTime = System.currentTimeMillis();
        long checkTime = nextTime - lastRequestTime;
        synchronized (this) {
            if (checkTime < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    wait(1000);
                }
            } else {
                zeroize();
            }
            System.out.println(message);
            lastRequestTime = System.currentTimeMillis();
        }

    }

    private void zeroize() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }
}
