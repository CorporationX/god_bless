package faang.school.godbless.BJS2_5750;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s is receiving %d %s\n", character, foodAmount, foodType);

        int waitingTime = new Random().nextInt(100, 500);
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        System.out.printf("After %d seconds %s is eating %d %s\n", waitingTime / 100, character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
