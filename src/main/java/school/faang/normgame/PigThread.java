package school.faang.normgame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j
@Getter
@RequiredArgsConstructor
public abstract class PigThread extends Thread {

    protected final String pigName;
    protected final String material;
    protected final int timeToBuild;

    @Override
    public void run() {
        try {
            log.info("{} строит дом из {}", pigName, material);
            Thread.sleep(timeToBuild);
            log.info("{} построил дом из {}", pigName, material);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("{} не смог построить дом из {}, что-то пошло не так: {}", pigName, material, e.getMessage());
        }
    }
}
