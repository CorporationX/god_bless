package faang.school.godbless.foods;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {

        try {
            String food = getFoodType();
            System.out.println(character + " gets " + foodAmount + " " + food);
            System.out.println("Delivery for " + character + " in progress");
            Thread.sleep(foodAmount * 1000L);
            System.out.println(character + " eats " + foodAmount + " " + food);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
