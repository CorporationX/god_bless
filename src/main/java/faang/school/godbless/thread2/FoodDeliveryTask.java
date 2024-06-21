package faang.school.godbless.thread2;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {

    private static final String MESSAGE_GET_FOOD = "%s получает %d %s \n";
    private static final String MESSAGE_EAT_FOOD = "%s ест %d %s \n";

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.format(MESSAGE_GET_FOOD, character, foodAmount, foodType);
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.format(MESSAGE_EAT_FOOD, character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
