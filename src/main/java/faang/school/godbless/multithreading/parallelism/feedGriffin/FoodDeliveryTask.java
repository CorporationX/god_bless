package faang.school.godbless.multithreading.parallelism.feedGriffin;

import lombok.Data;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    public void run() {
        String food = getFoodType();
        System.out.println(character + " getting " + foodAmount + " " + food);
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(character + " eating " + foodAmount + " " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
