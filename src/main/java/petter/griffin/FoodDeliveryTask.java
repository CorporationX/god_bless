package petter.griffin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
class FoodDeliveryTask implements Runnable {
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    private static final Random rand = new Random();

    private final String character;
    private int foodAmount;

    @Override
    public void run() {
        var food = getFoodType();
        System.out.printf("Giving %d %s to %s%n", foodAmount, food, character);
        try {
            Thread.sleep(1000L * (rand.nextInt(5) + 1));
            System.out.printf("%s starting to eat %d %s%n", character, foodAmount, food);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getFoodType() {
        return FOOD_TYPES[rand.nextInt(FOOD_TYPES.length)];
    }
}
