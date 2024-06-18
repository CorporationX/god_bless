package multithreading.feedgriffin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println(getCharacter() + " will get " + getFoodAmount() + " " + getFoodType());
        System.out.println(getCharacter() + " is waiting order...");
        System.out.println(getCharacter() + " is eating");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
