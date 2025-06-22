package school.faang.telegram;

import java.util.concurrent.Executors;

import static school.faang.ConcurrentUtils.shutdownExecutor;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
public class Main {

    private static final int THREADS_NUM = 10;

    public static void main(String[] args) {
        var bot = new TelegramBot();
        var executor = Executors.newFixedThreadPool(THREADS_NUM);
        for (int i = 0; i < THREADS_NUM; i++) {
            int finalId = i;
            executor.execute(() -> bot.sendMessage("Message %d".formatted(finalId)));
        }
        shutdownExecutor(executor);
    }
}
