package faang.school.godbless.kxnvg.telegrambot;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        TelegramBot bot1 = new TelegramBot(LocalDateTime.now());
        TelegramBot bot2 = new TelegramBot(LocalDateTime.now().minusSeconds(20));

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.execute(() -> bot1.sendMessage("Hello"));
            service.execute(() -> bot2.sendMessage("By"));
        }
        service.shutdown();

        try {
            service.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все сообщения успешно отправлены");
    }
}
