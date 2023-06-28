package feed_peter_griffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;
    public FoodDeliveryTask(String character, int foodAmount){
        this.character = character;
        this.foodAmount = foodAmount;
    }
    public void run(){
        String food = getFoodType();
        System.out.println(character+" gets "+foodAmount+" "+food);
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character+" eats "+foodAmount+" "+food);
    }
    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
