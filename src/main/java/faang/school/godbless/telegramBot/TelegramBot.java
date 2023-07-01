package faang.school.godbless.telegramBot;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long expired = System.currentTimeMillis() - lastRequestTime;
        System.out.println(expired);

        if (expired < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    wait(1000 - expired);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = 0;
        }

        notify();

        System.out.println(message);
    }
}
