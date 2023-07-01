package faang.school.godbless.feedPeterGriffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable{
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
        System.out.println(character + " gets " + foodAmount + " " + foodType);

        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(character + " eating " + foodAmount + " " + foodType);
    }
}
