package faang.school.godbless.multithreading.task_2.service;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%d of %s was send to %s%n", foodAmount, foodType, character);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s gets %d of %s%n", character, foodAmount, getFoodType());
        try {
            Thread.sleep(foodAmount * 100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s is eating %d of %s%n", character, foodAmount, getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
