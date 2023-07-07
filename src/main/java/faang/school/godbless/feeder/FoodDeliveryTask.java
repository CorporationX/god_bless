package faang.school.godbless.feeder;

import lombok.Data;
import java.util.Random;

@Data
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
        String foodType = this.getFoodType();
        System.out.println(this.character + " получает " + this.foodAmount + " " + foodType);
        try {
            Thread.sleep(new Random().nextInt(5) * 1000 + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.character + " ест " + this.foodAmount + " " + foodType);
    }
}
