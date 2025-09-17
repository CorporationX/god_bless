package school.faang.bjs2_89598;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public static FoodType getFoodType() {
        final Random random = new Random();
        return FoodType.values()[random.nextInt(FoodType.values().length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.printf("%s получает %d %s%n", character, foodAmount, foodType);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s ест %d %s%n", character, foodAmount, foodType);
    }
}
