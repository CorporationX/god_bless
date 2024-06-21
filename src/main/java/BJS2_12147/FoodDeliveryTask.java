package BJS2_12147;

import java.util.Random;
import java.util.concurrent.TimeUnit;

record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s get %d %s \n", character, foodAmount, foodType);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.printf("%s is eating %s \n", character, foodType);
    }
}
