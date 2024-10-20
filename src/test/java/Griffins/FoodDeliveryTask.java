package Griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final int DELAY = 5000;
    private final int MINIMUM_DELAY = 1000;

    private String character;
    private int foodAmmount;
    private Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmmount) {
        this.character = character;
        this.foodAmmount = foodAmmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        int index = random.nextInt(foodTypes.length);
        return foodTypes[index];
    }

    public void run() {
        String foodType = getFoodType();
        try {
            System.out.println(this.character + " receives " + this.foodAmmount + " " + this.getFoodType());
            Thread.sleep(random.nextInt(DELAY) + MINIMUM_DELAY);
            System.out.println(this.character + " eat " + this.foodAmmount + " " + this.getFoodType()
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(this.character + " couldn't get food " + this.getFoodType());
        }
    }
}
