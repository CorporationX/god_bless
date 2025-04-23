package feed.peter.griffin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String characterName;
    private int foodAmount;
    final Random random = new Random();

    @Override
    public void run() {
        FoodType randomFood = getFoodType();
        log.info("{} получает заказ из {} едениц {}...", characterName, foodAmount, randomFood);

        int randomMilisecodsForSleep = random.nextInt(1000, 5001);
        try {
            Thread.sleep(randomMilisecodsForSleep);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted! {}", e.getMessage());
            Thread.currentThread().interrupt();
        }

        log.info("{} получил заказ и ест {} едениц {}", characterName, foodAmount, randomFood);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
