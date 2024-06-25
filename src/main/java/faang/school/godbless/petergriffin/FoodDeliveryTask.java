package faang.school.godbless.petergriffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }
    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        try {
            String sent = String.format("%s получает %d еды",character,foodAmount);
            System.out.println(sent);
            Thread.sleep(foodAmount* 100L);
            System.out.println(String.format("%s  ест %d %s .",character,foodAmount,getFoodType()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
