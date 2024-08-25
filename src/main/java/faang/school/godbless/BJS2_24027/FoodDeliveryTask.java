package faang.school.godbless.BJS2_24027;

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
    public void run() throws RuntimeException {
        try {
            String foodType = getFoodType();
            System.out.printf("%s получает %d %s.%n", character, foodAmount, foodType);
            Thread.sleep(foodAmount * 1000L);
            System.out.printf("%s ест %d %s.%n", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s не смог получить свою еду.%n", character);
        }
    }
}
