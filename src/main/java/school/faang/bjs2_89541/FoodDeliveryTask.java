package school.faang.bjs2_89541;

import lombok.SneakyThrows;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final Random random = new Random();


    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @SneakyThrows
    public void run() {
        FoodType food = getFoodType();
        System.out.println(character + " receives " + foodAmount + " " + food);
        Thread.sleep(5000);
        System.out.println(character + " eat " + foodAmount + " " + food);
    }
}
