package school.faang.bjs2_92960;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Potion {

    private final String name;
    private final int requiredCount;

    public int gatherIngredient(Potion potion) throws InterruptedException {
        log.info("Starting to gather ingredients for {}", potion.getName());
        Thread.sleep(2_000L * potion.getRequiredCount());
        log.info("Finished gathering ingredients for {}", potion.getName());
        return potion.getRequiredCount();
    }
}
