package bot;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        TelegramBot bot = new TelegramBot();
        try (ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE)) {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executorService.execute(() -> {
                    for (int j = 0; j < 20; j++) {
                        bot.sendMessage(String.format("message_%d_%d", finalI, j));
                    }
                });
            }
            executorService.shutdown();
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("");
                log.info("Finished sending message");
            } else {
                log.error("Time out");
                executorService.shutdownNow();
            }
        }
    }
}
