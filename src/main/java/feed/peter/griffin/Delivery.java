package feed.peter.griffin;

import java.util.Random;

public class Delivery implements Runnable{
    int minDelay = 1000;
    int maxDelay = 5000;
    @Override
    public void run(){
        try {
            String foodType = getFoodType();
            System.out.println(character + " начинает доставку " + foodAmount + " " + foodType);

            Thread.sleep(new Random().nextInt(minDelay, maxDelay));

            System.out.println(character + " получает доставку: " + foodAmount + " " + foodType);

            Thread.sleep(new Random().nextInt(minDelay, maxDelay));

            System.out.println(character + " ест " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
