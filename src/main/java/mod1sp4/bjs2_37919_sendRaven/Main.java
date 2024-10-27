package mod1sp4.bjs2_37919_sendRaven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();
        Kingdom firstKingdom = new Kingdom("White Harbor");
        Kingdom secondKingdom = new Kingdom("Royal Harbor");
        CompletableFuture.allOf(IntStream.range(0, 10)
                .mapToObj(i -> ravenService.sendRaven(firstKingdom, secondKingdom)
                        .handle((result, exception) -> {
                                if (exception != null) {
                                    log.error("Error: {}", exception.getMessage());
                                } else {
                                    log.info(result);
                                }
                                return null;
        }))
                .toList()
                .toArray(new CompletableFuture[0]))
                .join();
        RavenService.shuttingDownExecutor();
    }
}
