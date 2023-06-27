package foodForPeterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    public void run() {
        String food = getFoodType();
        System.out.printf("%s is getting his %d %s.%n", character, foodAmount, food);
        int random = new Random().nextInt((5) + 1) * 1000;
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s successfully got food and eats %d %s.%n", character, foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
