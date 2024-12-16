package school.faang.bjs247736;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private final String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    private static final Random random = new Random();
    int randomSeconds = random.nextInt(4001) + 1000;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.println(character + " gets " + foodAmount + " " + foodType);
            Thread.sleep(randomSeconds);
            System.out.println(character + " eats " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}