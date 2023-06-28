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
        synchronized (this) {
            long currentTime = System.currentTimeMillis();
            long leftTime = currentTime - lastRequestTime;
            if (leftTime < 1000) {
                ++requestCounter;
                if (requestCounter > REQUEST_LIMIT) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (leftTime >= 1000){
                requestCounter = 0;
                lastRequestTime = 0;
                this.notifyAll();
            }
            System.out.println("Send message: " + message);
        }
    }
}
