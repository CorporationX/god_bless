package school.faang.bjs2_92603;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class Kingdom {
    @Getter
    private String name;

    public void sendMessage(Kingdom receiver) {
        if (ThreadLocalRandom.current().nextInt(100) < 30) {
            log.error("The raven did not reach {}", receiver.getName());
            throw new RavenDeliveryException("The raven did not reach " + receiver.getName());
        }

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("delivery interrupted");
            throw new RavenDeliveryException("Delivery interrupted");
        }
        log.info("Message delivered from {}", receiver.getName());
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
                sender.sendMessage(receiver);
                return "The message was successfully delivered from " + sender.getName() +
                        " in " + receiver.getName();
        });
    }

    class RavenDeliveryException extends RuntimeException {
        public RavenDeliveryException(String message) {
            super(message);
        }
    }

}
