package sprint4.griffin;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s gets %d %s\n", character, foodAmount, foodType);
        try {
            Thread.sleep(new Random().nextInt(5 * 1000));
        } catch (InterruptedException e) {
            System.out.printf("Thread \"%s\" completed", Thread.currentThread().getName());
        }
        System.out.printf("%s eat %d %s\n", character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
