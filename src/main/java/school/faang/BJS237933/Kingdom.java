package school.faang.BJS237933;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Data
@AllArgsConstructor
public class Kingdom {
    private static final int THREADS = 2;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    private String name;
    private final double chance = 0.50;

    public String sendMessage(Kingdom receiver) throws IllegalStateException {
         throwExceptionWithChance();
         return "Королевство отправило сообщение " + receiver.getName();
    }

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
       return CompletableFuture.supplyAsync(()-> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                log.error("Письмо не доставлено: ", e);
                throw new IllegalStateException(e);
            }
        }, executorService);
    }

    public void shutDown() {
        executorService.shutdown();
    }

    private void throwExceptionWithChance() {
        if (Math.random() > chance) {
            throw new IllegalStateException("Ворон сожрал письмо...");
        }
    }
}
