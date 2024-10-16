package Griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmmount;

    public FoodDeliveryTask(String character, int foodAmmount) {
        this.character = character;
        this.foodAmmount = foodAmmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    public void run() {
        Random random = new Random();
        String foodType = getFoodType();
        try {
            System.out.println(this.character + " receives " + this.foodAmmount + " " + this.getFoodType());
            Thread.sleep(random.nextInt(5000) + 1000);
            System.out.println(this.character + " eat " + this.foodAmmount + " " + this.getFoodType()
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(this.character + " couldn't get food " + this.getFoodType());
        }
    }
}
