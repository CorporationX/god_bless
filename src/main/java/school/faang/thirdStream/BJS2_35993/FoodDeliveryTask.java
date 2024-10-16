package school.faang.thirdStream.BJS2_35993;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.printf("%s получает %d %s от %s%n", character, foodAmount, foodType, Thread.currentThread().getName());

            Thread.sleep(new Random().nextInt(5000) + 1000);

            System.out.printf("%s ест %d %s%n", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            System.out.printf("%s не дождался %d %s из-за прерывания%n", character, foodAmount, foodType);
            e.printStackTrace();
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}