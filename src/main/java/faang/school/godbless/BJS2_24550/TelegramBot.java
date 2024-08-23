package faang.school.godbless.BJS2_24550;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final long SECOND = 1000L;

    private int requestCounter = 0;
    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void sendMessage(String message) {
        long timePassed = System.currentTimeMillis() - lastRequestTime;
        if (timePassed >= SECOND) {
            requestCounter = 0;
            lastRequestTime = System.currentTimeMillis();
        }

        requestCounter++;

        while (requestCounter > REQUEST_LIMIT) {
            try {
                long waitTime = SECOND - timePassed;
                String currentThreadName = Thread.currentThread().getName();

                if (waitTime > 0) {
                    System.out.println("Ждет секунду поток: " + currentThreadName);
                    wait(waitTime);
                } else {
                    System.out.println("Не ждет секунду, но начинает новый круг. Поток: " + currentThreadName);
                }

                lastRequestTime = System.currentTimeMillis();
                requestCounter = 1;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Отправка сообщения: " + message);
        notifyAll();
    }
}