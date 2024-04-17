package Multithreading_FeedPeteGriffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println("Начата доставка " + foodAmount + " " + getFoodType() + " персонажу " + character);
        try {
            Thread.sleep(foodAmount * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println(character + " получает " + foodAmount + " " + getFoodType() + " и начинает их есть.");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
