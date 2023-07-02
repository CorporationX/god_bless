package faang.school.godbless.spring_4.telegram_bot;

public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
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
                    while (checkTime < 1000) {
                        checkTime = System.currentTimeMillis() - checkTime;
                    }
                }
            } else {
                zeroize();
            }
            notifyAll();
        }
        System.out.println(message);
    }

    private void zeroize() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }
}
