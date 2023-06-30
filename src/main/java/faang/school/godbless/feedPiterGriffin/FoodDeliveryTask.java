package faang.school.godbless.feedPiterGriffin;

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
        String foodType = getFoodType();
        System.out.println(character + " will eat " + foodAmount + " " + foodType);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
