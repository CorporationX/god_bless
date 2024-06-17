package faang.school.godbless.feed_griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println(character + " заказывает " + foodAmount + " " + getFoodType());

        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
