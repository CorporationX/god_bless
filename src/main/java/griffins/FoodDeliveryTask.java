package griffins;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;
    private static final Random RANDOM = new Random();

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s получает %d %s%n", this.character, this.foodAmount, food);
        try {
            Thread.sleep(RANDOM.nextInt(1, 5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s ест %d %s%n", this.character, this.foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }
}
