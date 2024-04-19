package faang.school.godbless.TelegramBot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_MESSAGES = 100;
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        List<String> messages = getMessages();
        TelegramBot bot = new TelegramBot();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        for (String message : messages) {
            pool.execute(() -> {
                try {
                    bot.sendMessage(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        pool.shutdown();

        pool.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static List<String> getMessages() {
        List<String> messages = new ArrayList<>();
        IntStream.range(0, NUM_MESSAGES).forEach(i -> messages.add(String.valueOf(i)));
        return messages;
    }
}
