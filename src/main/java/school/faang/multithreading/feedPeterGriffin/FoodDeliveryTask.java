package school.faang.multithreading.feedPeterGriffin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.println(character + " заказал " + foodAmount + " " + foodType);
            Thread.sleep(new Random().nextInt(5000) + 1000);
            System.out.println(character + " ест " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            System.out.println(foodType + " не доехали до " + character);
            e.printStackTrace();
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
