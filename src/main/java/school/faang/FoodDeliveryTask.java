package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(FoodDeliveryTask.class);
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
        logger.info("{} gets {} {}.", character, foodAmount, foodType.name());
        try {
            Thread.sleep(random.nextInt(3000) + 1000);
        } catch (InterruptedException e) {
            logger.info("{} couldn't get {} {}.", character, foodAmount, foodType.name());
            throw new RuntimeException(e);
        }
        logger.info("{} eats {} {}.", character, foodAmount, foodType.name());
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
