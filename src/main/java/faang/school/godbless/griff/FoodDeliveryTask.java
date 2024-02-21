package faang.school.godbless.griff;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt( foodTypes.length )];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf( "%s is getting %d %s%n", character, foodAmount, foodType );
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        System.out.printf( "%s is eating %d %s%n", character, foodAmount, foodType );
    }
}
