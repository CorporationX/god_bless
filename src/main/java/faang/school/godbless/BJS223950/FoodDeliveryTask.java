package faang.school.godbless.BJS223950;

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
        try {
            System.out.println(character + " gets " + foodAmount + " " + getFoodType());
            Thread.sleep(foodAmount * 1000L);
            System.out.println(character + " eats " + foodAmount + " " + getFoodType());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
