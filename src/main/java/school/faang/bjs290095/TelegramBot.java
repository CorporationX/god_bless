package school.faang.bjs290095;

public class TelegramBot {
    private int requestCounter; //счетчик запросов в текущую секунду.
    private Long lastRequestTime; //время последнего запроса.

    private static final int REQUEST_LIMIT = 10; //максимальное количество запросов в секунду.

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;

        try {
            if (timeElapsed < 1000) {
                requestCounter++;

                if (requestCounter > REQUEST_LIMIT) {
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }

            System.out.println("Message sent: " + message);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
