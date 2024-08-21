package faang.school.godbless.food_delivery;

import java.util.Random;

import lombok.AllArgsConstructor;

import static java.lang.Thread.sleep;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        var picked = getFoodType();
        System.out.printf("%s will get %d %s(s)\n", character, foodAmount, picked);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s got %d %s(s)\n", character, foodAmount, picked);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
