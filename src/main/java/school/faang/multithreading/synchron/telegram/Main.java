package school.faang.multithreading.synchron.telegram;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        TelegramBot telegramBot = new TelegramBot();

        IntStream.range(0, 1_000_000)
                .forEach(i -> executor.submit(
                        () -> telegramBot.sendMessage("Поехали " + i)
                ));

        executor.shutdown();
        if (executor.awaitTermination(3, TimeUnit.MINUTES)) {
            log.info("Задача выполнена");
        }
    }
}
