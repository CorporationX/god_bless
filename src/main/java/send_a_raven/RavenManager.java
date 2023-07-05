package send_a_raven;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RavenManager {
    public CompletableFuture<Object> sendRaven(Kingdom sender, Kingdom receiver) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return CompletableFuture.supplyAsync(() -> {
                    if (sender == receiver) {
                        throw new RuntimeException(sender.getName() +
                                " tried send raven. | Error: You can't send ravens to yourself");
                    }
                    sender.sendMessage(receiver);
                    List<String> messagesKingdomTo = receiver.getMessages();
                    return messagesKingdomTo;
                }, executor)
                .handle((result, exception) -> {
                    if (exception != null) {
                        System.out.println(exception.getMessage());
                        return exception.getMessage();
                    } else {
                        System.out.println("  Message delivered from " + sender.getName() +
                                " to " + receiver.getName());
                        return receiver.getMessages();
                    }
                });
    }
}
