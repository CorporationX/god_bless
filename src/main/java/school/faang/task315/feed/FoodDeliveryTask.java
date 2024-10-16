package school.faang.task315.feed;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String characterName;
    private int foodAmount;

    @Override
    public void run() {
        try {

            String food = getFoodType();
            System.out.println(String.format("%s получает %d %s", characterName, foodAmount, food));
            Thread.sleep((new Random().nextInt(5)+1)*1000);
            System.out.println(String.format("%s ест %d %s", characterName, foodAmount, food));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
