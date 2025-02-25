package school.faang.BJS2_64043;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class Kingdom {
    private String name;

    private void sendMessage(Kingdom receiver) {
        log.debug("Королество {}отправляет сообщение королеству {}", this.name, receiver.getName());
    }

    private static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        Random random = new Random();
        return CompletableFuture.supplyAsync(() -> {
                try {

                }




        });

    }
}
