package school.faang.griffin;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private Random random;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @SneakyThrows
    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("\nНачали доставку %s, в количестве: %d,для %s",
                food, foodAmount, character);
        Thread.sleep(random.nextInt(5000) + 1000);
    }
}
