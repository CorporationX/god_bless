package bjs2_91047;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();
    private static final long ONE_SECOND = 1000L;

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
            System.out.printf("%s получает %d %s%n", character, foodAmount, foodType);
            Thread.sleep((random.nextInt(FoodType.values().length) + 1) * ONE_SECOND);
            System.out.printf("%s ест %d %s%n", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            System.out.printf("%s не смог получить %s из-за прерывания.%n", character, foodType);
            Thread.currentThread().interrupt();
        }
    }
}