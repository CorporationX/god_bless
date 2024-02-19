package faang.school.godbless.griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s receiving %d %s", character, foodAmount, foodType);
        System.out.println();
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s is eating %d %s", character, foodAmount, foodType);
        System.out.println();
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
