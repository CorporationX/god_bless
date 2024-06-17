package faang.school.godbless.BJS2_12068;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println("The delivery of: " + foodAmount + " packs of " + foodType + " has been started");
        try {
            Thread.sleep(new Random().nextInt(25)*1000);
            System.out.println(character + " has got his order consisted of " + foodAmount + " packs of " + foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
