package bjs2_91047;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        try {
            System.out.println(character + " получает " + foodAmount + " " + foodType);
            Thread.sleep((random.nextInt(5) + 1) * 1000L);
            System.out.println(character + " ест " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodType + " из-за прерывания.");
            Thread.currentThread().interrupt();
        }
    }
}