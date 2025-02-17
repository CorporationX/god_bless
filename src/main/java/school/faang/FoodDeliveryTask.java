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
        try {
            logger.info("{} gets {} {}.", character, foodAmount, foodType.name());
            Thread.sleep(random.nextInt(3000) + 1000);
            logger.info("{} eats {} {}.", character, foodAmount, foodType.name());
        } catch (InterruptedException e) {
            logger.info("{} couldn't eat {} {}.", character, foodAmount, foodType.name());
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
