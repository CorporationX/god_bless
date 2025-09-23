package school.faang.multithreading.parallelism.bjs2_91038;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int SLEEP_START_BORDER = 1000;
    private static final int SLEEP_END_BORDER = 5000;
    private String character;
    private int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, foodType.getValue());
        try {
            Thread.sleep(random.nextInt(SLEEP_START_BORDER, SLEEP_END_BORDER));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("{} ест {} {}", character, foodAmount, foodType.getValue());
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}