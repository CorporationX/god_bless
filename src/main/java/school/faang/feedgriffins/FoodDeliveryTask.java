package school.faang.feedgriffins;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final Random random = new Random();

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, foodType.name());
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(1000, 5000);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван {}", e.getMessage(), e);
        }
        log.info("{} ест {} {}", character, foodAmount, foodType.name());
    }

    private FoodType getFoodType() {
        FoodType[] foodFoodTypes = FoodType.values();
        return foodFoodTypes[random.nextInt(foodFoodTypes.length)];
    }
}
