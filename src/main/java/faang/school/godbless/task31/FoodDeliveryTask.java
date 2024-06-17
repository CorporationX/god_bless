package faang.school.godbless.task31;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;

    private int foodAmount;
    @Override
    public void run() {
        System.out.println(character+" is waiting for "+foodAmount+" "+ getFoodType());
        try {
            Thread.sleep(500);
            System.out.println(character+" eats "+foodAmount+" "+ getFoodType());
        } catch (InterruptedException e) {
            throw new RuntimeException("Delivery error");
        }

    }
    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
