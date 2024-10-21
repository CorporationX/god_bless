package peterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);
        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
