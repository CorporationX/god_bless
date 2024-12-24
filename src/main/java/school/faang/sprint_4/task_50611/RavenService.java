package school.faang.sprint_4.task_50611;

import java.util.concurrent.CompletableFuture;

public class RavenService {

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> sender.sendMessage(receiver));
    }
}
