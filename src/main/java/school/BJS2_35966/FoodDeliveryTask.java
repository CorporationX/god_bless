package school.BJS2_35966;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    private String name;
    private int foodAmount;

    @Override
    public void run() {

        String food = this.getFoodType();
        System.out.printf("%s получает %d %s", name, foodAmount, food);
        System.out.println();
        int threadSleepTime = new Random().nextInt(1000,5000);
        try {
            Thread.sleep(threadSleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s ест %d %s", name, foodAmount, food);
        System.out.println();

    }

    private String getFoodType() {
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
