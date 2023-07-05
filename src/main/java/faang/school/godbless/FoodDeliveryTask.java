package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    public String character;
    public int foodAmount;

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.println(character + " getting some " + getFoodAmount() + " " + getFoodType());
        System.out.println(character + " Waiting the deliveryClub");
        System.out.println(character + " get " + getFoodAmount() + " " + getFoodType());
    }
}
