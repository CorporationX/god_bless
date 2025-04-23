package school.faang.hungry_griffin;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private static final Random RANDOM = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        if (foodAmount > 0) {
            this.foodAmount = foodAmount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {} {}", character, foodAmount, foodType.name());
        try {
            Thread.sleep(RANDOM.nextInt(4) + 1);
            log.info("{} начал есть {} {}", character, foodAmount, foodType.name());

        } catch (InterruptedException e) {
            log.info("{} остался голодным", character);
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }
}
