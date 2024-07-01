package faang.school.godbless.send_crow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private final static ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final static long MESSAGE_SUPPLYING_TIME = 1000L;

    public static void main(String[] args) {
        Kingdom firstKingdom = new Kingdom("First");
        Kingdom secondKingdom = new Kingdom("Second");
        Kingdom thirdKingdom = new Kingdom("Third");

        CompletableFuture<String> firstToSecond = sendRaven(firstKingdom, secondKingdom)
                .handle((result, exception) -> exception == null ? result : "WASTED");

        CompletableFuture<String> secondToThird = sendRaven(secondKingdom, thirdKingdom)
                .handle((result, exception) -> exception == null ? result : "WASTED");

        executorService.shutdown();

        log.info("Result of first to second : " + firstToSecond.join());
        log.info("Result of second to third : " + secondToThird.join());
    }

    private static CompletableFuture<String> sendRaven(Kingdom senderKingdom, Kingdom recieverKingdom) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(MESSAGE_SUPPLYING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException("Raven was intercepted: " + e.getMessage());
            }

            if (ThreadLocalRandom.current().nextBoolean()) {
                throw new RuntimeException("Raven was intercepted");
            }

            senderKingdom.sendMessage(recieverKingdom);

            return "SUCCESS";
        }, executorService);
    }
}
