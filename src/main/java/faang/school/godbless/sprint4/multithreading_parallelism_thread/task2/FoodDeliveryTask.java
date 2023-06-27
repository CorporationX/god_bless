package faang.school.godbless.sprint4.multithreading_parallelism_thread.task2;

import java.util.Random;

public class FoodDeliveryTask implements Runnable{

    private String character;

    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        System.out.println(character + " получает " + foodAmount + " " + getFoodType());
        System.out.println(character + " ждет " + getFoodType());
        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
