package school.faang.sprint_4.bjs2_37937_raven;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 3;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        RavenService ravenService = new RavenService();
        Set<Kingdom> kingdoms = Set.of(
                new Kingdom("Avalonia"),
                new Kingdom("Eldorado"),
                new Kingdom("Caledonia"),
                new Kingdom("Valoria"),
                new Kingdom("Nimiera"),
                new Kingdom("Sylvania"),
                new Kingdom("Marinor"),
                new Kingdom("Veldoria"),
                new Kingdom("Albionia"),
                new Kingdom("Corvenia")
        );

        CompletableFuture.allOf(kingdoms.stream()
                .flatMap(sender -> kingdoms.stream()
                        .filter(receiver -> !sender.equals(receiver))
                        .map(receiver -> ravenService.sendRaven(sender, receiver)
                                .handle((result, e) -> {
                                            if (e != null) {
                                                log.error("An error occurred while handling sendRaven()", e);
                                            } else {
                                                log.info(result);
                                            }
                                            return null;
                                        }
                                )))
                .toList()
                .toArray(new CompletableFuture[0])).join();

        executor.shutdown();
    }
}
