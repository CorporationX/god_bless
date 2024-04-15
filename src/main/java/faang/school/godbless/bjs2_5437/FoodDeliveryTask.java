package faang.school.godbless.bjs2_5437;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = foodAmount + " " + getFoodType();
        System.out.println(character + " gets " + food);
        try {
            Thread.sleep(new Random().nextInt(5000 - 1000 + 1) + 1000);
            System.out.println(character + " eating " + food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
