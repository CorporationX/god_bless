package faang.school.godbless.parallelism.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.random.RandomGenerator;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        int timeToDelivery = RandomGenerator.getDefault().nextInt(1000, 5001);
        System.out.printf("%s ordered %d %s\n", character, foodAmount, foodType);
        try {
            Thread.sleep(timeToDelivery);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
        System.out.printf("%s ate %d %s\n", character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
