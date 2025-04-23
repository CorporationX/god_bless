package school.faang.peter_griffen;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Data
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[ThreadLocalRandom.current().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, foodType.getDisplayName());
        log.debug("Thread {} is executing for {}", Thread.currentThread().getName(), character);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 6000));
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            return;
        }
        log.info("{} ест {} {}", character, foodAmount, foodType.getDisplayName());
    }
}
