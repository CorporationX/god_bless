package school.faang.godbless.bjs2_37243;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = 20;
    private static final int NUMBER_OF_MESSAGES = 20;
    private static final int TIME_INTERVAL = 3000;
    private static final int REQUEST_LIMIT = 3;

    public static void main(String[] args) throws InterruptedException {
        TelegramBot bot = new TelegramBot(TIME_INTERVAL, REQUEST_LIMIT);
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        IntStream.rangeClosed(1, NUMBER_OF_MESSAGES).mapToObj(i -> "message" + i)
                .forEach(message -> pool.submit(() -> bot.sendMessage(message))
                );
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            log.info("Sent all messages");
        } else {
            log.error("The pool is not terminated");
        }
    }
}
