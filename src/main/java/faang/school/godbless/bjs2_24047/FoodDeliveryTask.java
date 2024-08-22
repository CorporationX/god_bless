package faang.school.godbless.bjs2_24047;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int THREAD_SLEEP_TIME = 5;

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character + " receives " + foodAmount + " " + food);
        try {
            Thread.sleep(1000 * (new Random().nextInt(THREAD_SLEEP_TIME) + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(character + " received all. " + character + " eats " + foodAmount + " " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
