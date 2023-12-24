package faang.school.godbless.multi.telegram;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;
    private static final long ONE_SECOND = 1000;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
     if (getTimeDifference() < ONE_SECOND) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    System.out.println("------------- Отправка ограничена -----------------\n");
                    Thread.sleep(ONE_SECOND - getTimeDifference());
                    requestCounter = 1;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Отправка прервана");
                }
            }
        } else {
            requestCounter = 1;
            System.out.println("--------------------------------------------------");
        }
        lastRequestTime = System.currentTimeMillis();
        sendToTelegramAPI(message);
    }

    private long getTimeDifference() {
        return System.currentTimeMillis() - lastRequestTime;
    }

    private void sendToTelegramAPI(String message) {
        System.out.println("Бот ответил на " + message);
    }
}
