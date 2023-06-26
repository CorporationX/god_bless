package faang.school.godbless.feedGriffin;

import lombok.Data;
import lombok.NonNull;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable{
    @NonNull
    private String character;
    @NonNull
    private int foodAmount;

    @Override
    public void run() {
        System.out.println(character + " получает " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep((int) Math.ceil(Math.random()*5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
