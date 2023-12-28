package Thread_2;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character + " take " + foodAmount + " " + food);
        try {
            Thread.sleep(1000);
            System.out.println(character + " eat " + foodAmount + " " + food);
        } catch (InterruptedException e) {
            System.out.println(character + " dropped " + foodAmount + " " + food + "! Stupid " + character);
        }
    }

    public String getCharacter() {
        return character;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
