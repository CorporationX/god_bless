package faang.school.godbless.griffin.food;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class FoodDeliveryTask implements Runnable {
    public static final int EXCLUSIVE_UPPER_BOUND_FOR_WAITING_FOOD = 5;
    public static final int INCLUSIVE_LOWER_BOUND_FOR_WAITING_FOOD = 1;

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
            int waitTime = new Random().nextInt(EXCLUSIVE_UPPER_BOUND_FOR_WAITING_FOOD) + INCLUSIVE_LOWER_BOUND_FOR_WAITING_FOOD;
            TimeUnit.SECONDS.sleep(waitTime);
        } catch (InterruptedException exception) {
            log.error(String.format("While %s was waiting for %s an error occurred", character, getFoodType()), exception);
        }

        System.out.printf("%s is eating food %s in amount: %d\n", character, getFoodType(), foodAmount);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
