package school.faang.bjs2_91046;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        String foodType = getFoodType().name();

        System.out.printf("%s is currently delivering %s for %s%n", Thread.currentThread()
                .getName(), foodType, character);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has delivered %s for %s%n", Thread.currentThread().getName(), foodType, character);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
