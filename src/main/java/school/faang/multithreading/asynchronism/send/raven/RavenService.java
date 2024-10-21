package school.faang.multithreading.asynchronism.send.raven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class RavenService {
    private static final int TIME_TO_DELIVERY = 2000;

    public CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(TIME_TO_DELIVERY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sender.sendMessage(receiver);
        });
    }
}
