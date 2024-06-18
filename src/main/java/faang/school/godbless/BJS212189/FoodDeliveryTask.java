package faang.school.godbless.BJS212189;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        try {
            String food = getFoodType();
            System.out.println(String.format("%s получает %s %s; в потоке %s", character, foodAmount, food, Thread.currentThread().getName()));
            Thread.sleep(foodAmount * 1000L);
            System.out.println(String.format("%s ест %s %s.", character, foodAmount, food));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
