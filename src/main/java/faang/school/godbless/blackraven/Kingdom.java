package faang.school.godbless.blackraven;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Kingdom {

    private String name;
    private final Random random = new Random();

    public void sendMessage(Kingdom kingdom) {
        if (random.nextBoolean()) {
            sleep(3L);
        } else {
            throw new RuntimeException("Internal error");
        }
    }

    private void sleep(Long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
