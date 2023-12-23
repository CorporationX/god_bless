package faang.school.godbless.multi.telegram;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - lastRequestTime;

        if (timeDiff < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    Thread.sleep(1000 - timeDiff);
                    lastRequestTime = System.currentTimeMillis();
                    requestCounter = 1;
                    System.out.println("--------------------------------------------------");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Отправка прервана");
                }
            }
        } else {
            requestCounter = 1;
            lastRequestTime = currentTime;
            System.out.println("--------------------------------------------------");
        }

        sendToTelegramAPI(message);
    }

    private void sendToTelegramAPI(String message) {
        System.out.println("Отправлено сообщение: " + message);
    }

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 53; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> bot.sendMessage("Сообщение " + finalI));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Отправка прервана");
            }
        }
    }
}
