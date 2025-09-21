package school.faang.multithreading.parallelism.bjs2_91038;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.printf("%s получает %d %s%n", character, foodAmount, foodType.getValue());
        try {
            Thread.sleep(random.nextInt(1000, 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("%s ест %d %s%n", character, foodAmount, foodType.getValue());
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}