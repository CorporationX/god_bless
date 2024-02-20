package faang.school.godbless.petergriffin;

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
        System.out.printf("%s is about to get %d %s\n", character, foodAmount, foodType);
        try {
            Thread.sleep(new Random().nextInt(5001));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s eats %d %s\n", character, foodAmount, foodType);
    }
}
