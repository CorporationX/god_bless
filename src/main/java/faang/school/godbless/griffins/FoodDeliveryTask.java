package faang.school.godbless.griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

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
        System.out.println(String.format("%s gets %d %s.", this.character, this.foodAmount, foodType));
        try {
            Thread.sleep(1000L * foodAmount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("%s eats  %d %s.", this.character, this.foodAmount, foodType));
    }
}
