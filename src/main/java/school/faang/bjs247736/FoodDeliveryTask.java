package school.faang.bjs247736;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    private static final Random random = new Random();
    private static final int RANDOM_SECONDS = random.nextInt(4001) + 1000;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.println(character + " gets " + foodAmount + " " + foodType);
            Thread.sleep(RANDOM_SECONDS);
            System.out.println(character + " eats " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}