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
        String food = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + food);
        try {
            Thread.sleep((new Random().nextInt(5) + 1)* 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " ест " + foodAmount + " " + food);
    }
}
