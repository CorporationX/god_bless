package faang.school.godbless.feed_peter;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }
}
