package school.faang.thirdStream.BJS2_37256;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        IntStream.range(0, 100)
                .forEach(i -> executor.submit(
                        () -> telegramBot.sendMessage("Поехали " + i)
                ));

        executor.shutdown();

        if (executor.awaitTermination(3, TimeUnit.MINUTES)) {
            log.info("Задача выполнена");
        }
    }
}
