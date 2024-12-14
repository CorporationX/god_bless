package school.faang.task_47727;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf(this.character + " gets %d: " + foodType + "\n", foodAmount);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupt!");
        }
        System.out.printf(this.character + " eats %d: " + foodType + "\n", foodAmount);
    }

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        Random random = new Random();
        int randomFoodType = random.nextInt(foodTypes.length);
        return foodTypes[randomFoodType];
    }
}
