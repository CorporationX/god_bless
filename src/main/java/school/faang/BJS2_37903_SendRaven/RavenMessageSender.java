package school.faang.BJS2_37903_SendRaven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RavenMessageSender {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            boolean isWillBeSent = ThreadLocalRandom.current().nextBoolean();
            if (isWillBeSent) {
                return sender.sendMessage(receiver);
            } else {
                throw new IllegalStateException(
                        String.format(
                                "Thread: %s. There are some problems with raven, the message from kingdom %s was not delivered to kingdom %s!",
                                Thread.currentThread().getName(), sender.getName(), receiver.getName()
                        )
                );
            }
        });
    }
}
