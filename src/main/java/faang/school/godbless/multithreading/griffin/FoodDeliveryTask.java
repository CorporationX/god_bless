package faang.school.godbless.multithreading.griffin;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {

    @Override
    public void run() {
        var foodType = getFoodType();
        System.out.println(String.format("%s gets %d %s", character, foodAmount, foodType));
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
            System.out.println(String.format("%s ate %d %s", character, foodAmount, foodType));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
