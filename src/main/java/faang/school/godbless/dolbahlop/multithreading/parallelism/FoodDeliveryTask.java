package faang.school.godbless.dolbahlop.multithreading.parallelism;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    @Override
    public void run() {
        System.out.println(character + " is getting " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(999, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " is eating " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
