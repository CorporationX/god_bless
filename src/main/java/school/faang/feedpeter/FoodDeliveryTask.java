package school.faang.feedpeter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, foodType);
        try {
            Thread.sleep(random.nextInt(1000, 5000));
            log.info("{} ест {} {}", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            log.error("Thread error: {}", e.getMessage());
        }
    }
}
