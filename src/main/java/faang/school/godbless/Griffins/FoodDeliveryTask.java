package faang.school.godbless.Griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;

    private final int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " receiving " + foodAmount + " " + foodType);
        try {
            Thread.sleep(foodAmount * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }
}
