package faang.school.godbless.telegramBot;

public class TelegramBot {
    private int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public void sendMessage(String message) {
        long timeRightNow = System.currentTimeMillis();
        if (timeRightNow - lastRequestTime < 1000) {
            requestCounter += 1;
            if (REQUEST_LIMIT < requestCounter) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (timeRightNow - lastRequestTime >= 1000) {
            lastRequestTime = timeRightNow;
            requestCounter = 0;
        }
        System.out.println("Sent message: " + message);
    }
}
