package school.faang.Multithreading.sprint_4.Crows;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class RavenService {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                log.error("Ошибка отправки сообщения");
                throw new RuntimeException(e);
            }
        }, executor);
    }

    public void shutdown(){
        executor.shutdown();
    }
}
