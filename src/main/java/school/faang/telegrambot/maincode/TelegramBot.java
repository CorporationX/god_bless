package school.faang.telegrambot.maincode;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = lastRequestTime - currentTime;

        try {
            if (timeElapsed < 1000) {
                requestCounter++;
                if (requestCounter == REQUEST_LIMIT) {
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
                notifyAll();
            }

            System.out.println("Send message " + message);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
