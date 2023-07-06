package faang.school.godbless.synchronizationWaitNotify.telegramBot;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        TelegramBot telegramBot = new TelegramBot();

        List<String> messages = List.of("hello", "world", "wait", "notify", "service", "executors", "main",
                "value", "message", "123", "mouse", "key", "nana", "sync", "wtf", "I", "don't", "understand",
                "which", "object", "should", "be", "lock");

        for (String message: messages) {
            executorService.submit(() -> telegramBot.sendMessage(message));
        }

        executorService.shutdown();
    }
}
