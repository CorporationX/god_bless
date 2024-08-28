package faang.school.multithreadingparallelismthread.pumpingalchemy;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PotionMaker {

    private static final long THREAD_TIME_SLEEP = 1000;

    public int gatherIngredients(@NonNull Potion potion) {
        try {
            Thread.sleep(potion.getRequiredIngredients() * THREAD_TIME_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Gathering ingredients interrupted", e);
            Thread.currentThread().interrupt();
        }
        log.info("Find {} ingredients for {}", potion.getRequiredIngredients(), potion.getName());
        return potion.getRequiredIngredients();
    }
}
