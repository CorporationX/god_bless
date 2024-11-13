package school.faangSprint3.t21;

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
        long timeElapsed = currentTime - lastRequestTime;

        try {
            if (timeElapsed < 1000) {
                requestCounter++;

                if (requestCounter > REQUEST_LIMIT) {
                    System.out.println("Превышен лимит запросов. Ожидание...");
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                    lastRequestTime = System.currentTimeMillis();
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }

            System.out.println(Thread.currentThread().getName() + ": Сообщение отправлено: " + message);
            Thread.sleep(100);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ошибка при отправке сообщения: " + e.getMessage());
        }
    }
}