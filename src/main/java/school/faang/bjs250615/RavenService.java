package school.faang.bjs250615;

import java.util.concurrent.CompletableFuture;

public class RavenService {

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> sender.sendMessage(receiver));
    }

}
