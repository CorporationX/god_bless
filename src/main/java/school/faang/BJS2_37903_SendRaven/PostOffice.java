package school.faang.BJS2_37903_SendRaven;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class PostOffice {
    public static void main(String[] args) {
        RavenMessageSender messageSender = new RavenMessageSender();

        Kingdom[] kingdoms = {
                new Kingdom("Aldoria"),
                new Kingdom("Bervenia"),
                new Kingdom("Celdonia")
        };

        sendMessageBetweenKingdoms(kingdoms, messageSender);
    }

    private static void sendMessageBetweenKingdoms(Kingdom[] kingdoms, RavenMessageSender messageSender) {
        List<CompletableFuture<?>> sendingFutureResults = new ArrayList<>();
        for (int senderIndex = 0; senderIndex < kingdoms.length - 1; senderIndex++) {
            for (int receiverIndex = senderIndex + 1; receiverIndex < kingdoms.length; receiverIndex++) {
                Kingdom sender = kingdoms[senderIndex];
                Kingdom receiver = kingdoms[receiverIndex];
                sendingFutureResults.add(
                        messageSender.sendRaven(sender, receiver)
                                .handle((result, error) -> {
                                    if (error != null) {
                                        log.info("Error occurred: {}", error.getMessage());
                                    } else {
                                        log.info(result);
                                    }
                                    return null;
                                })
                );
            }
        }
        CompletableFuture.allOf(sendingFutureResults.toArray(new CompletableFuture[0])).join();
    }
}
