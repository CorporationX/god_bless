package school.faang.bjs2_91285;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildHouses(int timeBuild) {
        try {
            log.info("{} started building a house from {}", pigName, material);
            Thread.sleep(timeBuild);
            log.info("{} finished  building a house from {}", pigName, material);
        } catch (InterruptedException e) {
            log.error("{} interrupted the construction of the house from {}", pigName, material, e);
            Thread.currentThread().interrupt();
        }
    }

}
