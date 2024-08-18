package faang.school.godbless.BJS2_23958;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s getting %d %s from thread №%d%n", character, foodAmount, food, Thread.currentThread().getId());
        try {
            int minSec = 1;
            int maxSec = 5;
            int sleepTime = (new Random().nextInt(maxSec) + minSec) * 1000;
            System.out.printf("%s is waiting %d seconds%n", character, sleepTime/1000);

            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has got %d %s from thread №%d%n", character, foodAmount, food, Thread.currentThread().getId());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
