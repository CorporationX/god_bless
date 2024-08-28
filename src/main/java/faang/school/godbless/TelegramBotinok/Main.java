package faang.school.godbless.TelegramBotinok;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(LocalDateTime.now(), 0);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    telegramBot.sendMessage(j + " " + Thread.currentThread().getName());
                }
            });
        }
        executor.shutdown();

//        Вообщем я так и не понял куда впихнуть notify и wait по человечески, потому я просто наворотил опять какой то ереси
    }
}
