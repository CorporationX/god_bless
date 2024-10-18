package school.faang.thirdStream.BJS2_35993;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random rnd = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.printf("%s получает %d %s от %s%n", character, foodAmount, foodType, Thread.currentThread().getName());

            Thread.sleep(rnd.nextInt(5000) + 1000);

            System.out.printf("%s ест %d %s%n", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            System.out.printf("%s не дождался %d %s из-за прерывания%n", character, foodAmount, foodType);
            e.printStackTrace();
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[rnd.nextInt(foodTypes.length)];
    }
}