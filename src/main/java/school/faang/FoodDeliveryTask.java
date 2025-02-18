package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(FoodDeliveryTask.class);
    private static final String LOG_EATING_START = "{} gets {} {}.";
    private static final String LOG_EATING_DONE = "{} eats {} {}.";
    private static final String LOG_EATING_FAILED = "{} couldn't eat {} {}.";
    private static final int MIN_EATING_TIME = 1000;
    private static final int MAX_EATING_TIME = 3000;

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        validateCharacter(character);
        validateFoodAmount(foodAmount);
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        FoodType foodType = getRandomFoodType();
        try {
            logger.info(LOG_EATING_START, character, foodAmount, foodType.name());
            Thread.sleep(random.nextInt(MAX_EATING_TIME) + MIN_EATING_TIME);
            logger.info(LOG_EATING_DONE, character, foodAmount, foodType.name());
        } catch (InterruptedException e) {
            logger.info(LOG_EATING_FAILED, character, foodAmount, foodType.name());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public FoodType getRandomFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    private void validateCharacter(String character) {
        if (character == null || character.isBlank()) {
            throw new IllegalArgumentException("Character can't be null or blank.");
        }
    }

    private void validateFoodAmount(int foodAmount) {
        if (foodAmount < 0) {
            throw new IllegalArgumentException("Amount of food can't be null or blank.");
        }
    }
}
