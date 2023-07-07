package faang.school.godbless.telegramBot;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private final Semaphore semaphore = new Semaphore(REQUEST_LIMIT, true);

    public void sendMessage(String message) throws InterruptedException {
        semaphore.acquire();
        send(message);
        TimeUnit.SECONDS.sleep(1);
        semaphore.release();
    }

    private void send(String msg) {
        System.out.println(msg + " was sent");
    }

}
