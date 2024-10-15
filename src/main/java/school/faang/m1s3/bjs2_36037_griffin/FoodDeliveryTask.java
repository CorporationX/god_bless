package school.faang.m1s3.bjs2_36037_griffin;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount = new Random().nextInt(1, 20);

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("Thread #%d: %s started to eat %d pieces of %s %n", Thread.currentThread().getId(), character, foodAmount, food);
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Thread #%d: %s finished %d pieces of %s %n", Thread.currentThread().getId(), character, foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
