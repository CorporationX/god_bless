package faang.school.godbless;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    public String getFoodType() {
        String[] foodTypes = {"пицца", "бургер", "хот-дог", "куриные-ножки", "тако"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);

        try {
            int deliveryTime = new Random().nextInt(5) + 1;
            Thread.sleep(deliveryTime * 1000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(character + " не удалось получить " + foodType + " из-за ошибки.");
        }

        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }
}
