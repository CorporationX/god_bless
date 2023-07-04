package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task2;

public class TelegramBot {

    private final int REQUEST_LIMIT;

    private int requestCounter;

    private long lastRequestTime;

    public TelegramBot(long lastRequestTime) {
        this.REQUEST_LIMIT = 5;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage(String message) throws InterruptedException {
        long duration = System.currentTimeMillis() - lastRequestTime;
        while (duration <= 3000 && requestCounter == REQUEST_LIMIT) {
            wait(3000 - duration);
            duration = System.currentTimeMillis() - lastRequestTime;
            if (duration > 3000 || requestCounter == REQUEST_LIMIT) {
                System.out.println("обнуление счетчика");
                requestCounter = 0;
            }
        }
        requestCounter++;
        lastRequestTime = System.currentTimeMillis();
        System.out.println(message + " lastRequestTime: " + lastRequestTime + " requestCounter: " + requestCounter);
        notifyAll();
    }
}

