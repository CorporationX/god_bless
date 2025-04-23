package school.faang.bjs2_72114;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class FoodDeliveryTask implements Runnable {

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
        FoodType foodType = getFoodType();

        log.info("{} получает {} {}\n", character, foodAmount, foodType);
        try {
            Thread.sleep(random.nextInt(5000));
            log.info("{} ест {} {}\n", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
