package faang.school.godbless.feed_piter_griffin;

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
        String foodType = getFoodType();

        System.out.println(character + " получает " + this.foodAmount + " " + foodType);

        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(character + " ест " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}