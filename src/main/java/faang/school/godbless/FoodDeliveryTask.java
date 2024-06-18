package faang.school.godbless;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character + " getting " + foodAmount + " " + food + "s");
        try {
            // sleeps randomly between 1 and 5 seconds
            Thread.sleep(new Random().nextInt(4000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " got " + foodAmount + " " + food + "s");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
