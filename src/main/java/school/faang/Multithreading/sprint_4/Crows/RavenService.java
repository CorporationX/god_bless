package school.faang.Multithreading.sprint_4.Crows;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class RavenService {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            return sender.sendMessage(receiver);
        });
    }
}
