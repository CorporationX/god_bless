package Sprint_4_Task2;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
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
        System.out.println(character + " Получает " + foodAmount + " " + getFoodType());
        System.out.println(character + " Ждет доставку " + foodAmount + " " + getFoodType());
        System.out.println(character + " Всё получил " + foodAmount + " " + getFoodType());
    }
}
