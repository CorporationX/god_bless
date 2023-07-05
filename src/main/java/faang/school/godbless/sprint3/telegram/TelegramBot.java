package faang.school.godbless.sprint3.telegram;

public class TelegramBot {
    private int REQUEST_LIMIT;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.REQUEST_LIMIT = 5;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastRequestTime < 1000) {
            ++requestCounter;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (timeNow - lastRequestTime > 1000) {
            lastRequestTime = timeNow;
            requestCounter = 0;
        }
        System.out.println(String.format("Sending message: %s", message));
    }


}
