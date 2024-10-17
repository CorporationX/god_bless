package ru.kraiush.BJS2_36012;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        String randomFood = getFoodType();
        System.out.println(character + " is receiving " + foodAmount + " " + randomFood);
        try {
            Thread.sleep(random.nextInt(1000, 5000));
            System.out.println(character + " is eating " + foodAmount + " " + randomFood);
        } catch (InterruptedException e) {
            System.out.println(character + "'s delivery was interrupted.");
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
