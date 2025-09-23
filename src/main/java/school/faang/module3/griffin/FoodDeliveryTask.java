package school.faang.module3.griffin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@RequiredArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private static final int LOWER_BOUND_DELAY = 1;
    private static final int UPPER_BOUND_DELAY = 1;
    private static final long ONE_SEC_IN_MILLIS = 1000;

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        FoodType rndFood = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, rndFood);
        try {
            Thread.sleep(getDelay());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted", e);
        }
        log.info("{} съел {} {}", character, foodAmount, rndFood);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    private long getDelay() {
        return random.nextInt(LOWER_BOUND_DELAY, UPPER_BOUND_DELAY) * ONE_SEC_IN_MILLIS;
    }
}
