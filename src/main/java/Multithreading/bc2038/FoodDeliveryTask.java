package Multithreading.bc2038;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;

    private int foodAmount;


    @Override
    public void run() {
        String food = getFoodType();
        try {
            System.out.println(getCharacter() + " получает " + getFoodAmount() + " " + food);
            Thread.sleep(foodAmount * 1000L);
            System.out.println(getCharacter() + " ест " + getFoodAmount() + " " + food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
