package griffinfood;

import lombok.Getter;

import java.util.Random;
import java.util.logging.Logger;

@Getter
public class FoodDeliveryTask implements Runnable {
    private static final Logger logger = Logger.getLogger(FoodDeliveryTask.class.getName());
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(int foodAmount, String character) {
        this.foodAmount = foodAmount;
        this.character = character;
    }

    public FoodType getFoodType() {
        FoodType[] availableFoodTypes = FoodType.values();
        return availableFoodTypes[random.nextInt(availableFoodTypes.length)];
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            String foodDescription = getFoodType().getDescription();
            logger.info(threadName + ": " + character + " gets " + foodAmount + " " + foodDescription);
            Thread.sleep(1000 + random.nextInt(4000));
            logger.info(threadName + ": " + "Food successfully delivered! " + character + " eats " + foodDescription);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe("Delivery was interrupted for " + character + " deliverer is lost!");
        }
    }
}
