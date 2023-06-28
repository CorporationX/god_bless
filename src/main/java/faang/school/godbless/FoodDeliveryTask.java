package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(Thread.currentThread().getName() +
                " thread | " + character + " getting " + foodAmount + " " + foodType);
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +
                " thread | " + character + " eating " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizzas", "burgers", "hot dogs", "chicken wings", "tacos"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
