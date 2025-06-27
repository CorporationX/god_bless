package school.faang.bjs2_82303;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Kingdom {
    private final String name;

    public String sendMessage(Kingdom receiver) {
        boolean isDelivered = ThreadLocalRandom.current().nextDouble() > 0.3;
        if (!isDelivered) {
            throw new MessageIsNotDelivered("Сообщение из " + name + " не доставлено в " + receiver.name);
        }
        return "Сообщение из " + name + " доставлено в " + receiver.name;
    }

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> sender.sendMessage(receiver));
    }
}
