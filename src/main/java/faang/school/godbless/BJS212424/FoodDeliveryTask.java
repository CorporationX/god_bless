package faang.school.godbless.BJS212424;

import jdk.jfr.StackTrace;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " gets " + foodAmount + " of " + foodType);
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during sleep", e);
        }
        System.out.println(character + " eats " + foodAmount + " of " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
