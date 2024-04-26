package faang.school.godbless.bjs2_5957;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        Kingdom starks = new Kingdom("Stark");
        Kingdom grayjoys = new Kingdom("Grayjoy");
        Kingdom tallys = new Kingdom("Tally");
        Kingdom lannisters = new Kingdom("Lannister");

        List<CompletableFuture<Void>> futures = List.of(sendRaven(starks, grayjoys), sendRaven(tallys, lannisters), sendRaven(lannisters, starks));
        futures.forEach(future -> future.handle((msg, ex) -> {
            if (ex != null) {
                log.error("Exception handle, message: {}", ex.getMessage());
                return null;
            } else {
                return msg;
            }
        }).join());

        shutdownExecutor();

        try {
            while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("All operations executed!");
    }

    public static CompletableFuture<Void> sendRaven(Kingdom from, Kingdom to) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                if (ThreadLocalRandom.current().nextBoolean()) {
                    throw new RavenException("The raven from " + from.getName() + " did not reach the " + to.getName());
                }
                from.sendMessage(to);
                log.info("Message from {} to {} successfully delivered!", from.getName(), to.getName());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }, executorService);
    }

    public static void shutdownExecutor() {
        executorService.shutdown();
    }
}
