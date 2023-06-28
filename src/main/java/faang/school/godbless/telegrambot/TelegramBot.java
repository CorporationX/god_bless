public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter = 0;
    private long lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT, long lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long timeSpent = startTime - lastRequestTime;

        if (timeSpent < 1000) {
            requestCounter++;
        } else {
            requestCounter = 0;
            lastRequestTime = 0;
        }

        if (requestCounter > REQUEST_LIMIT) {
            Thread.sleep(1000 - timeSpent);
            this.wait();
        } else {
            this.notify();
        }

        System.out.println(Thread.currentThread().getName() + " Sending message: " + message);
    }
}
