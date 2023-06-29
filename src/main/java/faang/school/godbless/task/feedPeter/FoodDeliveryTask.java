package faang.school.godbless.task.feedPeter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.println(character + " gets " + foodAmount + " " + getFoodType());

        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " eats " + foodAmount + " " + getFoodType());
    }
}
