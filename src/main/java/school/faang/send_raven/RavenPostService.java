package school.faang.send_raven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class RavenPostService {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
