package faang.school.godbless.sprint3.grifin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s gets %d %s%n", character, foodAmount, food);
        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s eat %d %s%n", character, foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
