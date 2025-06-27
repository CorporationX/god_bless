package school.faang.sprint3.bjs2_81830;

public class TelegramBot {
    public static final int REQUEST_LIMIT = 5;
    public static final int LIMIT_INTERVAL = 1000;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTimeMillis = System.currentTimeMillis();
        long diff = currentTimeMillis - lastRequestTime;
        try {
            Thread.sleep(100);
            if (diff < LIMIT_INTERVAL) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    long timeoutMillis = LIMIT_INTERVAL - diff;
                    wait(timeoutMillis);
                    System.out.println("Превышение лимита, ожидание: " + timeoutMillis);
                    requestCounter = 1;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTimeMillis;
                notifyAll();
            }
            System.out.println("Отправлено сообщение: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
