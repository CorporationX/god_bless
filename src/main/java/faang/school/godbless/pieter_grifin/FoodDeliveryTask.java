package faang.school.godbless.pieter_grifin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class FoodDeliveryTask implements Runnable {
    private String characterName;
    private int foodAmount;

    @Override
    public void run() {
        String getFood = getFoodType();
        System.out.println(characterName + " receiving " + foodAmount + " " + getFood);
        System.out.println();
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Delivering " + foodAmount + " food items to " + getCharacterName());
        System.out.println(characterName + " eating " + foodAmount + " " + getFood);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
