package faang.school.godbless.familyguy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
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
        String food = getFoodType();
        System.out.println(character + " gets " + foodAmount + " " + food);
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " eats " + foodAmount + " " + food);
    }
}
