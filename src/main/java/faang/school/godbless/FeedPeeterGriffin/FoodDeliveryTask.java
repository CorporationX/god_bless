package faang.school.godbless.FeedPeeterGriffin;

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

        System.out.println(character + " receives " + foodAmount + " of " + getFoodType());

        try {
            Thread.sleep(new Random().nextInt((4001) + 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interruption at delivering eat to " + character + "!!!!!");
        }

        System.out.println(character + " get his/her amount of eat: " + foodAmount);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
