package school.faang.sprint_3.task_49209;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int MILLIS_IN_SECOND = 1000;
    private int requestCounter = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void sendMessage(String message) {
        while (true) {
            long now = System.currentTimeMillis();
            long millisAfterLastRequest = now - lastRequestTime;

            if (millisAfterLastRequest >= MILLIS_IN_SECOND) {
                lastRequestTime = now;
                requestCounter = 0;
                notifyAll();
            }

            if (requestCounter < REQUEST_LIMIT) {
                requestCounter++;
                System.out.println(message + " sent by " + Thread.currentThread().getName() + " at " + now);
                return;
            }

            try {
                long waitTime = MILLIS_IN_SECOND - millisAfterLastRequest;
                if (waitTime > 0) {
                    wait(waitTime);
                }
            } catch (InterruptedException e) {
                System.out.println("Message send interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
