package feed.peter.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    final static int MAX_WAIT_TIME = 5;
    static Random random = new Random();

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(this.character + " gets " + this.foodAmount + " " + foodType);
        try {
            Thread.sleep((random.nextInt(MAX_WAIT_TIME - 1) + 1) * 1000);
            System.out.println(this.character + " eats " + this.foodAmount + " " + foodType);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
