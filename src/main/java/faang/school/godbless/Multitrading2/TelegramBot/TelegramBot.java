package faang.school.godbless.Multitrading2.TelegramBot;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.REQUEST_LIMIT = 5;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public void sendMessage(String message){
        long currentTime = System.currentTimeMillis();
        long leftTime = currentTime - lastRequestTime;
        if (leftTime < 1000){
            ++requestCounter;
            if (requestCounter > REQUEST_LIMIT){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = 0;
        }
        System.out.println("Send message: " + message);
    }
}
