package school.faang.bjs2_72124;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int UPPER_BORDER = 5000;
    private static final int LOWER_BORDER = 1000;

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        FoodType food = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, food);
        try {
            Thread.sleep(random.nextInt(LOWER_BORDER, UPPER_BORDER));
            log.info("{} ест {} {}", character, foodAmount, food);
        } catch (InterruptedException e) {
            log.error("Проблема в доставке: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}