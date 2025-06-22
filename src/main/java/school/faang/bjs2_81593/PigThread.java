package school.faang.bjs2_81593;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildHouse(int delay) {
        log.info("{} начал строить дом из {}", getPigName(), getMaterial());

        try {
            Thread.sleep(delay); // Симулируем время строительства
        } catch (InterruptedException e) {
            log.error("Pig {} interrupted while building the house", getPigName(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        log.info("{} закончил строить дом из {}", getPigName(), getMaterial());
    }
}
