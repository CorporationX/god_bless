package faang.school.godbless.FeedPeterGriffin;

import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.Random;

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
        System.out.println(Instant.now() + " " + character + " gets " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep((int) (Math.random() * 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Instant.now() + " " + character + " received the delivery");
    }
}