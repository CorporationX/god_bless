package school.faang.multithreading.parallelism.normal.game;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class PigThread extends Thread {
    private String name;
    protected Material material;

    @SneakyThrows
    public void buildHouse(int buildTime) {
        log.info("{} начинает строить дом из материала: {}", name, material.getRusName());
        Thread.sleep(buildTime);
        log.info("{} построил дом из материала: {}", name, material.getRusName());
    }
}
