package school.faang.sprint_4.bjs2_37937_raven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class RavenService {
    private final ExecutorService executor;

    public RavenService(ExecutorService executor) {
        this.executor = executor;
    }

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (RavenLostException e) {
                throw new RuntimeException(e);
            }
        }, executor);
    }
}
