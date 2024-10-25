package school.faang.sendaravane;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class RavenService {

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (ThreadLocalRandom.current().nextInt(100) < 30) {
                throw new RuntimeException("Raven failed to deliver the message!");
            }

            sender.sendMessage(receiver);
            return "Message successfully delivered from " + sender.getName() + " to " + receiver.getName();
        });
    }
}