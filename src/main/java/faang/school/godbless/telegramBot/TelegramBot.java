package faang.school.godbless.telegramBot;

public class TelegramBot {

    private final int SECOND = 1000;
    private int REQUEST_LIMIT = 5; // огранич. по запросу
    private int requestCounter; // счетчик запросов
    private long lastRequestTime; // время ластового запроса

    public synchronized void sendMessage(String message) {
        long timeRightNow = System.currentTimeMillis();
        if (timeRightNow - lastRequestTime < 1000) {
            requestCounter += 1;
            if (REQUEST_LIMIT < requestCounter) {
                try {
                    Thread.sleep(SECOND + lastRequestTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            lastRequestTime = timeRightNow;
            requestCounter = 0;
        }
        System.out.println("Sent message: " + message);
    }
}
