package faang.school.godbless.feed_peter_griffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s ordered: %s %s '%s'\n", character, foodAmount, food, Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s eats: %s %s '%s'\n", character, foodAmount, food, Thread.currentThread().getName());
    }

    private String getFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }
}
