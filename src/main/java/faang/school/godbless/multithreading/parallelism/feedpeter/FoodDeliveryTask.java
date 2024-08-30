package faang.school.godbless.multithreading.parallelism.feedpeter;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " get " + foodAmount + " " + foodType);

        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        }

        System.out.println(character + " eat " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
