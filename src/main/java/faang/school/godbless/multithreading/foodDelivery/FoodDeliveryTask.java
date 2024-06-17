package faang.school.godbless.multithreading.foodDelivery;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int RANDOM_DELIVERY_TIME = 5000;
    private static final int MIN_DELIVERY_TIME = 1000;

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s is waiting for %d %s \n", character, foodAmount, foodType);
        try {
            Thread.sleep(new Random().nextInt(RANDOM_DELIVERY_TIME) + MIN_DELIVERY_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s is eating %d %s \n", character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
