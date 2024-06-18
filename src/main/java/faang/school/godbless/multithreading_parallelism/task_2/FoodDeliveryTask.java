package faang.school.godbless.multithreading_parallelism.task_2;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private int foodAmount;

    private static final int MIN_TIME_DELIVERY = 1000;
    private static final int MAX_TIME_DELIVERY = 5000;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.println(character + " is getting " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(new Random().nextInt(MIN_TIME_DELIVERY, MAX_TIME_DELIVERY));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " is eating " + foodAmount + " " + getFoodType());
    }
}
