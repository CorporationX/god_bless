package feed_peter_griffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

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
        System.out.println(character + " gets " + foodAmount + " " + foodType);
        try {
            Thread.sleep(new Random().nextInt(1,6) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " eats " + foodAmount + " " + foodType);
    }
}
