package school.faang.BJS2_61181;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class FoodDeliveryTask implements Runnable {
    private static final int MAX_DELIVERY_TIME = 5000;
    private static final int MIN_DELIVERY_TIME = 1000;
    private static final String BEGIN_TASK_MESSAGE = "{} gets {} {}";
    private static final String END_TASK_MESSAGE = "{} got {} {}";
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType food = getFoodType();
        log.info(BEGIN_TASK_MESSAGE, character, foodAmount, food.toString());
        try {
            Thread.sleep(random.nextInt(MIN_DELIVERY_TIME, MAX_DELIVERY_TIME));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info(END_TASK_MESSAGE, character, foodAmount, food);
    }
}
