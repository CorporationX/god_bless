package faang.school.godbless.telegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(5);
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        executorService.execute(() -> telegramBot.sendMessage("Hello"));
        executorService.execute(() -> telegramBot.sendMessage("World"));
        executorService.execute(() -> telegramBot.sendMessage("!"));
        executorService.execute(() -> telegramBot.sendMessage("Are"));
        executorService.execute(() -> telegramBot.sendMessage("There"));

        executorService.shutdown();
    }
}
