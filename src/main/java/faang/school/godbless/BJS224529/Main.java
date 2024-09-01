package faang.school.godbless.BJS224529;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int REQUEST_LIMIT = 5;
    private static final int NUM_THREADS = 10;
    private static final int LOOP_COUNT = 10;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(REQUEST_LIMIT);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < LOOP_COUNT; i++) {
            int finalI = i;
            executor.submit(() -> {
                try {
                    bot.sendMessage("Message " + finalI);
                } catch (InterruptedException e) {
                    System.err.println("Error sending message: " + e.getMessage());
                }
            });
        }
        executor.shutdown();
    }
}
