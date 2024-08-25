package com.multithreading.griffin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println(character + " получает " + foodAmount + " " + getFoodType());
        try {
            TimeUnit.SECONDS.sleep((int) (Math.random()*(5-1+1) + 1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
