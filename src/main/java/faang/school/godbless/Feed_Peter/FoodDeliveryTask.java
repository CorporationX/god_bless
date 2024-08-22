package faang.school.godbless.Feed_Peter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
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
            System.out.println(character + " receives " + foodAmount + " " + getFoodType());
            Thread.sleep(2000);
            System.out.println(character + " eats " + foodAmount + " " + getFoodType());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
