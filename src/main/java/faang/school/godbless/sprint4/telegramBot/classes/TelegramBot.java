package faang.school.godbless.sprint4.telegramBot.classes;

import lombok.SneakyThrows;

public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    private Integer requestCounter;
    private Long lastRequest;

    public TelegramBot() {
        requestCounter = 0;
        lastRequest = System.currentTimeMillis();
    }

    public void sendMessage(String message) {
        validate();
        send(message);
    }

    @SneakyThrows
    private void validate() {
        long curRequest = getNow();
        if (curRequest - lastRequest < 1000) {
            requestCounter++;
        } else {
            requestCounter = 0;
        }
        synchronized (this) {
            if (requestCounter > REQUEST_LIMIT) {
                Thread.sleep(1000 - (curRequest - lastRequest));
                requestCounter = 0;
            }
        }
        lastRequest = curRequest;
    }

    private void send(String s) {
        System.out.println(s + " is sent");
    }

    private static long getNow() {
        return System.currentTimeMillis();
    }
}
