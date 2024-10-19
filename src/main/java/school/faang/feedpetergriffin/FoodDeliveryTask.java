package school.faang.feedpetergriffin;

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
        String foodType = getFoodType();
        System.out.println(character + " is receiving " + foodAmount + " " + foodType);

        try {
            int delay = new Random().nextInt(5) + 1;
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delivery interrupted for " + character);
        }

        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }
}
