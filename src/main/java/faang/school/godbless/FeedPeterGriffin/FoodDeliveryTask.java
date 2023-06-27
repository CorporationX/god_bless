package faang.school.godbless.FeedPeterGriffin;

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
        try {
            String foodType = getFoodType();
            System.out.println(character + " is waiting by " + foodAmount + " " + foodType);
            Thread.sleep(2000);
            System.out.println(character + " is eating by " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
