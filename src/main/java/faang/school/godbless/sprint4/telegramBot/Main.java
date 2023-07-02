package faang.school.godbless.sprint4.telegramBot;

import faang.school.godbless.sprint4.telegramBot.classes.TelegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int NUM_THREAD = 10;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREAD);

        for (int i = 0; i < 200; i++) {
            String message = "Message " + i;
            service.execute(() -> {
                bot.sendMessage(message);
            });
        }

        service.shutdown();
    }
}
