package school.faang;

import java.util.concurrent.CompletableFuture;

public class RavenService {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> sender.sendMessage(receiver))
                .handle((result, ex) -> {
                    if (ex != null) {
                        return "Error: " + ex.getMessage();
                    } else {
                        return result;
                    }
                });
    }

}
