package school.faang.raven;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    private String sendMessage(Kingdom receiver) throws Exception {
        int random = new Random().nextInt(100);
        if (random < 50) {
            throw new Exception("The message has not been delivered from Kingdom + " + name + " to " + receiver.getName());
        }
        return "The message has been successfully delivered from Kingdom " + name + " to " + receiver.getName();
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() ->
        {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, executor);
    }
}
