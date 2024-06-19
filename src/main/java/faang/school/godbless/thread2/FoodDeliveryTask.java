package faang.school.godbless.thread2;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.format("%s получает %d %s \n", character, foodAmount, foodType);
        System.out.format("%s ест %d %s \n", character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
