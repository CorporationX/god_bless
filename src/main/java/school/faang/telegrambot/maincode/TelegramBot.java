package school.faang.telegrambot.maincode;

import java.sql.Timestamp;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public void sendMessage(String message) {
        System.out.println("Имитация отправки сообщения через стрим апи");
        long startTime = System.currentTimeMillis();

    }
}
