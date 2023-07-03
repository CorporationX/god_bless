package faang.school.godbless.griffin;

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

        System.out.printf("%s gets %s %s%n",character, foodAmount, foodType);

        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s is eats %s %s%n",character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
