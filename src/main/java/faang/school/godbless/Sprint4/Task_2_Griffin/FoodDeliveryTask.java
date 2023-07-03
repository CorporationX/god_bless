package faang.school.godbless.Sprint4.Task_2_Griffin;

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
        System.out.println(character + " gets " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " eats " + foodAmount + " " + getFoodType());
    }
}
