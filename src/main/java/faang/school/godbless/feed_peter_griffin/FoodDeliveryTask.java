package faang.school.godbless.feed_peter_griffin;

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
        System.out.printf("%s заказал %s %s.\n", character, foodAmount, getFoodType());
        try {
            Thread.sleep(new Random().nextInt(100, 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("%s получил доставку.\n", character);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}