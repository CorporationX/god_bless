package faang.school.godbless.sprint3.griffin;

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
        System.out.println(String.format("%s got %d %s.", character, foodAmount, getFoodType()));
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("%s got food and eats %d %s.", character, foodAmount, getFoodType()));
    }
    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
