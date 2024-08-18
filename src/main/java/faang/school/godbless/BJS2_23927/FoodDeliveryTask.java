package faang.school.godbless.BJS2_23927;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        try {
            String foodType = this.getFoodType();
            System.out.printf("%s gets %s %s%n", this.character, this.foodAmount, foodType);
            Thread.sleep(foodAmount + 1000);
            System.out.printf("%s is eating %s %s%n", this.character, this.foodAmount, foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
