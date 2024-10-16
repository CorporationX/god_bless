package feed_peter_griffin;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private static final Random random = new Random();
    private static final int MIN_DELAY = 1;
    private static final int MAX_DELAY = 5;
    private String foodType = null;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    /**
     * Runs the food delivery task.
     * <p>
     * This will simulate the food delivery by printing out the character's name, the amount of food they get
     * and the food type. Then it will wait for a random amount of time between 1 and 5 seconds and print out
     * that the character is eating the food.
     */
    @Override
    public void run() {
        String randomFoodType = getRandomFoodType();

        setFoodType(randomFoodType);

        System.out.printf("%s gets %d %s\n", character, foodAmount, randomFoodType);

        try {
            Thread.sleep(random.nextInt(MAX_DELAY - MIN_DELAY) + MIN_DELAY);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Gets a random food type from the {@link #FOOD_TYPES} array.
     *
     * @return A food type.
     */
    private String getRandomFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }
}
