package faang.school.godbless.feed_peter;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Что пошло не так(");
        }

        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }
}
