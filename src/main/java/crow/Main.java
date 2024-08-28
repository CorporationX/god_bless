package crow;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 20;

    public static void main(String[] args) throws InterruptedException {
        var kingdoms = initKingdoms();
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            var futures = kingdoms.stream()
                    .flatMap(k -> Stream.of(k)
                            .flatMap(i -> kingdoms.stream()
                                    .filter(o -> !o.equals(k)))
                            .map(o -> CompletableFuture.runAsync(
                                            () -> sendRaven(k, o), executor)
                                    .handle((r, e) -> {
                                        if (e != null) {
                                            log.error(e.getMessage());
                                            return false;
                                        } else {
                                            log.info(String.format(
                                                    "Crow successfully delivered message from %s to %s",
                                                    k.getName(), o.getName()));
                                            return true;
                                        }
                                    })))
                    .toList();
            futures.forEach(CompletableFuture::join);
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Finished");
            } else {
                log.error("Time out");
            }
        }
    }

    private static void sendRaven(
            @NonNull Kingdom kingdomFrom, @NonNull Kingdom kingdomTo
    ) throws CrowFailedException {
        kingdomFrom.sendMessage(kingdomTo);
    }

    private static List<Kingdom> initKingdoms() {
        return List.of(
                new Kingdom("The North"),
                new Kingdom("The Vale of Arryn"),
                new Kingdom("The Riverlands"),
                new Kingdom("The Iron Islands"),
                new Kingdom("The Westerlands"),
                new Kingdom("The Crownlands"),
                new Kingdom("The Reach"),
                new Kingdom("The Stormlands"),
                new Kingdom("Dorne"));
    }
}
