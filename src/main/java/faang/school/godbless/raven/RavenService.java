package faang.school.godbless.raven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class RavenService {

    public static CompletableFuture<String> sendRaven(Kingdom fromKingdom, Kingdom toKingdom) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    if (ThreadLocalRandom.current().nextInt(2) == 0) {
                        throw new RuntimeException("Raven dead");
                    } else {
                        return "Raven from " + fromKingdom.name() + " say to " + toKingdom.name() + " winter is coming";
                    }
                })
                .handle((message, exception) -> {
                    if (message != null && !message.isBlank()) {
                        return message;
                    } else {
                        return "My lord " + exception.getCause().getMessage();
                    }
                });
    }
}
