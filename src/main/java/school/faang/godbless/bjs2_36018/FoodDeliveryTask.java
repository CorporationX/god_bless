package school.faang.godbless.bjs2_36018;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private static final int MIN_DELIVERY_TIME = 1000;
    private static final int MAX_DELIVERY_TIME = 5000;
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        log.info("Delivering food to: {} Amount: {} Food type: {}", character, foodAmount, foodType);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_DELIVERY_TIME, MAX_DELIVERY_TIME + 1));
            log.info("Food delivered to: {} Amount: {} Food type: {}", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            log.warn("Food delivery interrupted");
            Thread.currentThread().interrupt();
        }
    }

    private String getFoodType() {
        return FOOD_TYPES[ThreadLocalRandom.current().nextInt(FOOD_TYPES.length)];
    }
}
