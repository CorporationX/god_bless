package faang.school.godbless.griffins;

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
        int timeForDelivery = new Random().nextInt(6);
        String foodType = getFoodType();
        System.out.println(character + " is receiving " + foodAmount + " " + foodType);
        try {
            Thread.sleep(timeForDelivery * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }
}
