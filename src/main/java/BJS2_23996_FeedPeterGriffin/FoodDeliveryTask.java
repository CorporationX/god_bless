package BJS2_23996_FeedPeterGriffin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
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
        System.out.println(getCharacter() + " takes " + getFoodAmount() + " " + getFoodType());
        System.out.println("Waiting when " + getCharacter() + " got delivery...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getCharacter() + " eats " + getFoodAmount() + " " + getFoodType());
    }
}
