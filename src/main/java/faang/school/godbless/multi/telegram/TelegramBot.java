package faang.school.godbless.multi.telegram;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        lastRequestTime = System.currentTimeMillis();

        if (getTimeDifference() < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    System.out.println("------------- Отправка ограничена -----------------\n");
                    Thread.sleep(1000 - getTimeDifference());
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

        sendToTelegramAPI(message);
    }

    private long getTimeDifference() {
        return System.currentTimeMillis() - lastRequestTime;
    }

    private void sendToTelegramAPI(String message) {
        System.out.println("Бот ответил на " + message);
    }
}
