package school.faang.sprint4.task50970;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task50970.model.Kingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int MAX_RAVENS = 10;

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("kingdom of crooked mirrors");
        Kingdom kingdom2 = new Kingdom("Monako");

        List<CompletableFuture<String>> ravenResults = new ArrayList<>();

        for (int i = 0; i < MAX_RAVENS; i++) {
            CompletableFuture<String> ravenResult = sendRaven(kingdom1, kingdom2)
                    .handle((result, exception) -> {
                        if (exception != null) {
                            log.error("Ворон не смог доставить сообщение из замка {} в замок {}",
                                    kingdom1.getName(), kingdom2.getName());
                        } else {
                            log.info("Ворон доставил сообщение из замка {} в замок {}",
                                    kingdom1.getName(), kingdom2.getName());
                        }
                        return result;
                    });
            ravenResults.add(ravenResult);
        }

        CompletableFuture.allOf(ravenResults.toArray(new CompletableFuture[ravenResults.size()])).join();

    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
