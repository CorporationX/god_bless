package faang.school.godbless.multithreading.petergriffin;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        var food = getFoodType();
        System.out.printf("%s receives %d %s\n", character, foodAmount, food);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Thread was interrupted: %s\n", e.getMessage());
            return;
        }
        System.out.printf("%s is eating %d %s\n", character, foodAmount, food);

    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[ThreadLocalRandom.current().nextInt(foodTypes.length)];
    }
}
