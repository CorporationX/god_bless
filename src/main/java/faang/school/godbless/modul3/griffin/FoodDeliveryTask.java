package faang.school.godbless.modul3.griffin;

import lombok.AllArgsConstructor;

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
        System.out.println(character + " get " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(character + " eat " + foodAmount + " " + getFoodType());
    }
}
