package faang.school.godbless.griffin.food;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.printf("%s is waiting for food %s in amount: %d\n", character, getFoodType(), foodAmount);

        try {
            int waitTime = new Random().nextInt(5) + 1;
            Thread.sleep(waitTime * 1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.printf("%s is eating food %s in amount: %d\n", character, getFoodType(), foodAmount);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
