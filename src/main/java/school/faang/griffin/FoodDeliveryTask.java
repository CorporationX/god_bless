package school.faang.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private static final int MILLISECONDS_TO_SECONDS = 1000;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();

        try {
            System.out.println(character + " takes " + foodAmount + " " + foodType);
            Random random = new Random();
            int randomSeconds = random.nextInt(5) + 1;
            Thread.sleep(randomSeconds * MILLISECONDS_TO_SECONDS);
            System.out.println(character + " is eating " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            System.out.println(character + " didn't take " + foodAmount + foodType);
            e.printStackTrace();
        }
    }
}
