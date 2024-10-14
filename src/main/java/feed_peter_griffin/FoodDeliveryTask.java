package feed_peter_griffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private static final Random random = new Random();
    private static final int MIN_DELAY = 1;
    private static final int MAX_DELAY = 5;

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
        String foodType = getFoodType();

        System.out.printf("%s gets %d %s\n", character, foodAmount, foodType);

        try {
            Thread.sleep(random.nextInt(MAX_DELAY - MIN_DELAY) + MIN_DELAY);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }

        System.out.printf("%s eats %d %s\n", character, foodAmount, foodType);
    }

    /**
     * Gets a random food type from the {@link #FOOD_TYPES} array.
     *
     * @return A food type.
     */
    private String getFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }
}
