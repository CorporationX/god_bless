package school.faang.bjs2_91035;


import ch.qos.logback.core.joran.conditional.ThenAction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int TIME_FOR_LUNCH = 2000;
    private static final Random random = new Random();
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        try {
            log.info("{} gets food - {} {}", character, foodAmount, foodType);
            Thread.sleep(TIME_FOR_LUNCH);
            log.info("{} devoured {} {}", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("{} was interrupted: ", Thread.currentThread().getName(), e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
