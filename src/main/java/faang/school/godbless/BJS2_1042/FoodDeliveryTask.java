package faang.school.godbless.BJS2_1042;

import java.util.Random;
import java.util.random.RandomGenerator;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        try {
            String food = getFoodType();
            System.out.printf("%s получает %d %s\n", character, foodAmount, food);
            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 5000));
            System.out.printf("%s получил %d %s\n", character, foodAmount, food);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}