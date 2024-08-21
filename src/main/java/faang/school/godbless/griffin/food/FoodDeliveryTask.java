package faang.school.godbless.griffin.food;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Slf4j
public class FoodDeliveryTask implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(FoodDeliveryTask.class);
    private final String character;
    private final int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        System.out.printf("%s is waiting for food %s in amount: %d\n", character, getFoodType(), foodAmount);

        try {
            int waitTime = new Random().nextInt(5) + 1;
            Thread.sleep(waitTime * 1000);
        } catch (InterruptedException exception) {
            logger.error(String.format("While %s was waiting for %s an error occurred", character, getFoodType()), exception);
        }

        System.out.printf("%s is eating food %s in amount: %d\n", character, getFoodType(), foodAmount);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
