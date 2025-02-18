package school.faang.feedpeter;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodDeliveryTask.class);

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
        LOGGER.info("{} получает {} {}", character, foodAmount, foodType);
        try {
            Thread.sleep(random.nextInt(1000, 5000));
        } catch (InterruptedException e) {
            LOGGER.error("Thread error: {}", e.getMessage());
        }
        LOGGER.info("{} ест {} {}", character, foodAmount, foodType);
    }
}
