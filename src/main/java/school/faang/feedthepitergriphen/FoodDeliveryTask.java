package school.faang.feedthepitergriphen;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final Random RANDOM = new Random();
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        FoodType food = getFoodType();
        log.info("\nДоставщик забрал ваш заказ.\n * {} ждет свою еду!*", character);
        try {
            int deliveryTime = RANDOM.nextInt(5) + 1;
            Thread.sleep(RANDOM.nextInt(deliveryTime));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info(e.getMessage());
        }
        log.info("Ваш заказ доставлен : * {} {}\n {}  счастлив! *\n", foodAmount, food, character);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }

}
