package school.faang.feedthepitergriphen;

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

    @Override
    public void run() {
        FoodType food = getFoodType();
        LOGGER.info("\nДоставщик забрал ваш заказ.\n * {} ждет свою еду!*", character);
        try {
            int deliveryTime = random.nextInt(5) + 1;
            Thread.sleep(random.nextInt(deliveryTime));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("Ваш заказ доставлен : * {} {}\n {}  счастлив! *\n", foodAmount, food, character);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

}
