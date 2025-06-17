package school.faang.module1.bjs2_81063;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    private static final int MIN_DELAY_MS = 1000;
    private static final int MAX_DELAY_MS = 5000;

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, foodType);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_DELAY_MS, MAX_DELAY_MS));
            log.info("{} ест {} {}", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток был прерван");
        }
    }

    public FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[ThreadLocalRandom.current().nextInt(foodTypes.length)];
    }
}