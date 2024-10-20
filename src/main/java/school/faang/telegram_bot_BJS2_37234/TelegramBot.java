package school.faang.telegram_bot_BJS2_37234;

public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private final int SECOND = 1000;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - lastRequestTime;

        if (timeDifference < SECOND) {
            requestCounter++;

            if (requestCounter > REQUEST_LIMIT) {
                try {
                    System.out.println("Request limit exceeded. Waiting 1 second");
                    wait(SECOND - timeDifference);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
                requestCounter = 0;
                lastRequestTime = System.currentTimeMillis();
                notifyAll();
            }
        } else {
            requestCounter = 1;
            lastRequestTime = System.currentTimeMillis();
        }
        System.out.println("Message sent: " + message);
    }
}