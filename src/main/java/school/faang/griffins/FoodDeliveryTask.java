package school.faang.griffins;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final Random random = new Random();
    private String character;
    private final int foodAmount = random.nextInt(1, 20);

    private static final Logger LOGGER = Logger.getLogger(FoodDeliveryTask.class.getName());

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(character + " is getting " + foodAmount + " " + foodType);
        int deliveryTime = random.nextInt(1000, 5000);
        try {
            Thread.sleep(deliveryTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info(character + " is eating " + foodAmount + " " + foodType);
    }
}
