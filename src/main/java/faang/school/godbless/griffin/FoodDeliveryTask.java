package faang.school.godbless.griffin;

import java.security.SecureRandom;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
    @Override
    public void run() {
        final String food = getFoodType();
        System.out.println(character + " getting " + food + " in amount " + foodAmount + "...");
        try {
            Thread.sleep(foodAmount / 2 * 1000L);
            System.out.println(character + " got his food.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " eat " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        int rand = new SecureRandom().nextInt(foodTypes.length);
        return foodTypes[rand];
    }
}
