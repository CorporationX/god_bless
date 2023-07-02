package Sprint_4_Task_Feed_Peter_Griffin;

import lombok.SneakyThrows;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String characterName;
    private int foodAmount;

    public FoodDeliveryTask(String characterName, int foodAmount) {
        this.characterName = characterName;
        this.foodAmount = foodAmount;
    }

    @SneakyThrows
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " " + characterName + " получает " + foodAmount + " " + getFoodType());
        System.out.println(Thread.currentThread().getName() + " " + characterName + " ест " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
