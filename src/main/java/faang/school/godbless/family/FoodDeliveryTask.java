package faang.school.godbless.family;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        try {
            System.out.println(character + " получает " + foodAmount + " " + getFoodType());
            Thread.sleep(foodAmount * 1000L);
            System.out.println(character + " ждет доставку");
            Thread.sleep(foodAmount * 1000L);
            System.out.println(character + " ест " + foodAmount + " " + getFoodType());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
