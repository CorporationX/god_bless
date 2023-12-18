package Griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    public FoodDeliveryTask(String character) {
        this.character = character;
        this.foodAmount = new Random().nextInt(100);
    }

    @Override
    public void run() {
        System.out.println(character + " gets " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " eats " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
