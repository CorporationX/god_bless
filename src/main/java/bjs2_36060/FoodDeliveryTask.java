package bjs2_36060;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private Random random;
    private String[] foodTypes;


    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
        this.random = new Random();
        this.foodTypes = new String[]{"pizza", "burger", "hot dog", "chicken wings", "taco"};
    }

    private String getFoodType() {
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        try {
            String foodType = getFoodType();
            System.out.println(character + " gets " + foodAmount + " " + foodType);
            Thread.sleep(getRandomDelay());
            System.out.println(character + " eats " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getRandomDelay() {
        return random.nextInt(6) * 1000;
    }
}
