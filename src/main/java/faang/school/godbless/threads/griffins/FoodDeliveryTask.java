package faang.school.godbless.threads.griffins;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.println(String.format("%s ordered %d amount of %s", character, foodAmount, getFoodType()));
        try {
            Thread.sleep((new Random().nextInt(5) + 1) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("%s is eating %d amount of %s", character, foodAmount, getFoodType()));
    }
}
