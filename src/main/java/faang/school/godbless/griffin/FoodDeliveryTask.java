package faang.school.godbless.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println(character + " получает " + foodAmount + " " + getFoodType());
        System.out.println(character + " ждет");
        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[(new Random().nextInt(foodTypes.length))];
    }
}