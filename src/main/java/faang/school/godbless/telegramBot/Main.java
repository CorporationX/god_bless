package faang.school.godbless.telegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        TelegramBot bot = new TelegramBot();

        for (int i = 0; i < 20; i++) {
            executor.submit(bot::sendMessage);
        }
    }
}
