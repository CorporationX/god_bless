package school.faang.bjs2_72124;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private Random random = new Random();

    @Override
    public void run() {
        FoodType food = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, food);
        try {
            Thread.sleep(random.nextInt(1, 5));
            log.info("{} ест {} {}", character, foodAmount, food);
        } catch (InterruptedException e) {
            log.error("Проблема в доставке: {}", e.getMessage());
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}