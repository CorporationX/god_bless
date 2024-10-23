package school.faangSprint3.t12;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.println(character + " получает " + foodAmount + " " + foodType);
            Thread.sleep(random.nextInt(5000) + 1000);
            System.out.println(character + " ест " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodType + " из-за прерывания.");
            Thread.currentThread().interrupt();
        }
    }
}