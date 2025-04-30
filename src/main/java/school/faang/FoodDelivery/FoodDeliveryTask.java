package school.faang.FoodDelivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int MILLIS_IN_SECOND = 1000;
    private static final int MAX_DELAY_SECONDS = 5;
    private final Random random = new Random();
    private String character;
    private int foodAmount;

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType food = getFoodType();
        log.info("{} is getting  {} {}  ", character, foodAmount, food);
        int delay = random.nextInt(MAX_DELAY_SECONDS) + 1;
        try {
            Thread.sleep(delay * MILLIS_IN_SECOND);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread was interrupted");
            return;
        }
        log.info("{} is eating {} {}.", character, foodAmount, food);
    }
}
