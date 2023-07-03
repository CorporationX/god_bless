package faang.school.godbless.Sprint4.Telegram;

import java.time.LocalDateTime;

import static java.time.Duration.between;

public class TelegramBot implements Runnable {
    private final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalDateTime lastRequestTime;

    TelegramBot(int requestCounter, LocalDateTime lastRequestTime) {
        this.requestCounter = requestCounter;
        this.lastRequestTime = lastRequestTime;
    }

    public synchronized void sendMessage() throws InterruptedException {
        Long duration = between(lastRequestTime,LocalDateTime.now()).toMillis();
        System.out.println("С прошлого вызова: " + duration + " За последние 1 секнуды " + requestCounter);
        if (duration < 1000) {
            requestCounter++;
            if (requestCounter >= REQUEST_LIMIT) {
                Thread.sleep(1000 - duration);
                requestCounter--;
            }
            System.out.println("ну, как будто бы");
        } else {
            requestCounter = 1;
            System.out.println("ну, как будто бы");
        }
        lastRequestTime = LocalDateTime.now();
    }

    @Override
    public void run() {
        try {
            sendMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
