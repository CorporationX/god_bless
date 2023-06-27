package faang.school.godbless.griffins;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodOrdered = getFoodType();
        System.out.println(character + " ordered: " + foodOrdered + ", quantity: " + foodAmount);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(foodOrdered + " arrived for " + character);
        System.out.println(Thread.currentThread().getName());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
