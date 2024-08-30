package crow;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Kingdom {
    private final String name;

    public void sendMessage(@NonNull Kingdom kingdom) throws CrowFailedException {
        if (ThreadLocalRandom.current().nextInt(100) > 90) {
            throw new CrowFailedException(
                    String.format("Crow from %s lost his way to %s", name, kingdom.getName()));
        } else {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
