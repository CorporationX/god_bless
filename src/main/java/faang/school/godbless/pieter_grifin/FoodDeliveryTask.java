package faang.school.godbless.pieter_grifin;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class FoodDeliveryTask implements Runnable {
    private String characterName;
    private int foodAmount;

    public FoodDeliveryTask(String characterName, int foodAmount) {
        this.characterName = characterName;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        System.out.println(characterName + " receiving " + foodAmount + " " + getFoodType());
        System.out.println();
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Delivering " + foodAmount + " food items to " + getCharacterName());
        System.out.println(characterName + " eating " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
