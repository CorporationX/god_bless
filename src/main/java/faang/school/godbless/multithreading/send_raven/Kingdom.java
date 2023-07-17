package faang.school.godbless.multithreading.send_raven;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    private void sendMessage(Kingdom kingdom) {
        System.out.println("Sending a message to kingdom " + kingdom.getName() + " from " + name);
        try {
            TimeUnit.SECONDS.sleep(name.length());
            if (new Random().nextBoolean()) {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Void> sendRaven(Kingdom kingdom) {
        return CompletableFuture.runAsync(() -> sendMessage(kingdom)).handle((str, ex) -> {
            if (ex != null) {
                return "Message not delivered";
            } else {
                return "Message delivered";
            }
        }).thenAccept(res -> System.out.println(res + ", from " + name + " to " + kingdom.getName()));
    }
}
