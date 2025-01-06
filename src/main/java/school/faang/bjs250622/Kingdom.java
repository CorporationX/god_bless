package school.faang.bjs250622;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
public class Kingdom {
    @Getter
    private final String name;

    private final Random random = new Random();
    private static final double ERROR_PERSENTAGE = 0.3;
    private static final int PROCESS_TIME = 1000;

    @SneakyThrows
    public String sendMessage(Kingdom receiver) {

        if (random.nextDouble() < ERROR_PERSENTAGE) {
            Thread.sleep(PROCESS_TIME);
            throw new Exception("Raven was unable to deliver it from " + name
                    + " to " + receiver.getName());
        }
        Thread.sleep(PROCESS_TIME);
        return "It delivered from " + name + " to " + receiver.getName();
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}