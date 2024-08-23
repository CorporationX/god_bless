package faang.school.godbless.Griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final String foodType = getFoodType();

    @Override
    public void run() {
        System.out.println("Food for " + character + " has delivered\n                        " + foodType + " Amount: " + foodAmount);
        for (int i = 1; i < foodAmount + 1; i++) {
            System.out.println(character + " ate " + i + " ");
        }
        System.out.println(character + " all eaten");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
