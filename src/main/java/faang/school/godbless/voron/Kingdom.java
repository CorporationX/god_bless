package faang.school.godbless.voron;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;


@RequiredArgsConstructor
@Data
public class Kingdom {

    private final String name;
    private List<String> messages = new ArrayList<>();

    public CompletableFuture<String> sendMessage(Kingdom kingdom, String message) {
        System.out.println("Kingdom " + this.name + " is sending to " + kingdom.name + " a message: " + message);

        return CompletableFuture.supplyAsync(() -> {
            if (new Random().nextInt(1, 4) == 1) {
                throw new RuntimeException("Message was lost");
            } else {
                kingdom.getMessages().add(message);
                return message;
            }
        });
    }
}
