package school.faang.griffins;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final Random random = new Random();
    private String character;
    private final int foodAmount = random.nextInt(1, 20);

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} is getting {} {}", character, foodAmount, foodType);
        int deliveryTime = random.nextInt(1000, 5000);
        try {
            Thread.sleep(deliveryTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} is eating {} {}", character, foodAmount, foodType);
    }
}
