package school.faang.bjs250622;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import static school.faang.bjs250622.Kingdom.sendRaven;

@Slf4j
public class Main {
    private static final int RAVENS_AMOUNT = 5;

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("kingdom_1");
        Kingdom kingdom2 = new Kingdom("kingdom_2");

        List<CompletableFuture<String>> futures = IntStream.range(0, RAVENS_AMOUNT)
                .mapToObj(i -> sendRaven(kingdom1, kingdom2)
                        .handle((result, exception) -> {
                            if (exception != null) {
                                log.error("Raven was unable to deliver a message from {} to {}",
                                        kingdom1.getName(), kingdom2.getName());
                            } else {
                                log.info("Message delivered from {} to {}",
                                        kingdom1.getName(), kingdom2.getName());
                            }
                            return result;
                        }))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}