package school.faang.multithreading.parallelism.feed.peter.griffin;

import lombok.SneakyThrows;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @SneakyThrows
    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + character + " gets " + foodAmount + " " + foodType);
        Thread.sleep(random.nextInt(4000) + 1000);
        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + character + " eats " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
