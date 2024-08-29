package faang.school.godbless.BJS2_24735;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class KingdomMessageService {
    public static void main(String[] args) {
        Kingdom sender = new Kingdom("Westeros");
        Kingdom receiver = new Kingdom("Braavos");

        sendRaven(sender, receiver)
                .thenAccept(System.out::println)
                .join();

        sendRaven(receiver, sender)
                .thenAccept(System.out::println)
                .join();
    }

    private static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
                    sender.sendMessage(receiver);
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                        throw new RuntimeException(e);
                    }
                    return "The message has been delivered";
                })
                .handle((message, exception) -> exception != null ? "The message was not delivered" + exception.getMessage() : message);
    }

}
