package feed.peter.griffin;

import java.util.Random;

public class Delivery implements Runnable{
    @Override
    public void run(){
       // System.out.println(character + " gets " + foodAmount + getFoodType());
        System.out.println(character + " get "  + + foodAmount + " " + getFoodType());
    }

    private String character;
    private int foodAmount;

    public Delivery(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
