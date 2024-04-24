package task13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    public void run() {
        try {
            String food = getFoodType();
            System.out.println(character + " get " + foodAmount + " " + food);
            Thread.sleep(10000);
            System.out.println(character + " eat " + foodAmount + " " + food);
        } catch (InterruptedException e) {
            System.out.println("Работа потока была прервана");
        }
    }
}