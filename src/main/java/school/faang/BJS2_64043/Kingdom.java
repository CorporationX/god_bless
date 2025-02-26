package school.faang.BJS2_64043;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom receiver) {
        log.debug("Королевство {} отправляет сообщение королевству {}", this.name, receiver.getName());
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.debug("Письмо отправлено...");
                TimeUnit.SECONDS.sleep(1);
                if (Math.random() < 0.5) {
                    return "Письмо успешно доставлено из " + sender.getName() + " в " + receiver.getName();
                } else {
                    throw new RuntimeException("письмо не доставлено, ворон пропал");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Произошла ошибка при отправке письма", e);
            }
        });
    }
}