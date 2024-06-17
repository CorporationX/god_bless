package faang.school.godbless.multithreading.family_guy;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;

    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();

        System.out.println(character + " получает " + foodAmount + " " + food);
        System.out.println("Доставка для " + character + "...");
        System.out.println(character + " ест " + foodAmount + " " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}