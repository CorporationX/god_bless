package school.faang.bjs2_72460.thread;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class PigThread extends Thread {
    private static final int BUILDING_DURATION = 3000;

    protected final String pigName;
    protected final String material;

    @Override
    public void run() {
        try {
            log.info("{} начал строить дом из {}", getPigName(), getMaterial());
            Thread.sleep(BUILDING_DURATION);
            log.info("{} закончил строить дом из {}", getPigName(), getMaterial());
        } catch (InterruptedException e) {
            log.error("Во время постройки дома возникло исключение: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}