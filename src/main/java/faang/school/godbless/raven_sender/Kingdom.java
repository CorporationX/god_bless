package faang.school.godbless.raven_sender;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
public class Kingdom {

    private String name;

    public CompletableFuture<Void> sendRaven(Kingdom destination, String message) {
        Raven raven = new Raven(destination, message);

        return CompletableFuture.supplyAsync(() -> {
            if (winterIsComing()) {
                raven.flyingToDestination();
                System.out.println(message);
            } else {
                throw new RuntimeException("You know nothing John Snow");
            }

            return null;
        });
    }

    private boolean winterIsComing() {
        return new Random().nextBoolean();
    }
}
