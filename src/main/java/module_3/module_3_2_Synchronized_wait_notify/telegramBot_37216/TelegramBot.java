package module_3.module_3_2_Synchronized_wait_notify.telegramBot_37216;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 3;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long diffTime = currentTime - lastRequestTime;
        try {
            if (diffTime < 1000) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    wait(1000 - diffTime);
                    requestCounter = 0;
                    lastRequestTime = System.currentTimeMillis();
                }
            } else {
                requestCounter = 1;
                lastRequestTime = System.currentTimeMillis();
                notifyAll();
            }
            System.out.println(Thread.currentThread().getName() + " Сообщение отправлено: " + message + " в " + lastRequestTime);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
