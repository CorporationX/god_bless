package faang.school.godbless.BJS2_24014;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        var foodType = getFoodType();
        System.out.println(character + ": is getting " + foodAmount + " " + foodType);

        try {
            Thread.sleep(new Random().nextInt(1000, 5001));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
