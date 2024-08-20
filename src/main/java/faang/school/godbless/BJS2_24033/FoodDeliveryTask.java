package faang.school.godbless.BJS2_24033;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private final String foodType = getFoodType();

    @Override
    public void run() {
        System.out.println(character + " ordered " + foodAmount + " " + foodType);

        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " eating " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
