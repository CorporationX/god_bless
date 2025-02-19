package school.faang.BJS2_61181;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private static final int DELIVERY_TIME = 5;
    private final String character;
    private final int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        Random random = new Random();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {

    }
}
