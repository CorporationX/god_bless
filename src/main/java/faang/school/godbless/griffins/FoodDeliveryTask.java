package faang.school.godbless.griffins;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    private String getFoodType() {
        Random random = new Random();
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.println(character + " gets " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(character + " eats " + foodAmount + " " + getFoodType());
    }
}
