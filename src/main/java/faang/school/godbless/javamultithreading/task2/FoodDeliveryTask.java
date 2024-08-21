package faang.school.godbless.javamultithreading.task2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
@AllArgsConstructor
public class FoodDeliveryTask  implements Runnable {
    private static String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + food);
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " ест " + foodAmount + " " + food);
    }

    private String getFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }
}
