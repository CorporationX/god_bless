package faang.school.godbless.bjs225886;

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
            System.out.println(this.character + " is waiting for food");
            Thread.sleep(foodAmount * 1000L);
            System.out.println(this.character + " gets " + foodAmount + " " + getFoodType());
        } catch (InterruptedException e) {
            System.err.println(character + " did not receive the food: Delivery was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}