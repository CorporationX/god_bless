package faang.school.godbless.sprint_3.multithreading.petter_griffin_eat;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;

    private int foodAmount;

    public void run() {
        String food = getFoodType();
        System.out.println(String.format("%s is getting his %d %s.", character, foodAmount, food));
        int random = new Random().nextInt((5) + 1) * 1000;
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s successfully got food and eats %d %s.", character, foodAmount, food));
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
