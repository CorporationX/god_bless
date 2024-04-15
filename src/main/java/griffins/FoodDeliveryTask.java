package griffins;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{

    private String character;
    private int foodAmount;
    @SneakyThrows
    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(String.format("%s получает %d %s", this.character, this.foodAmount, food));
        Thread.sleep(new Random().nextInt(1, 5));
        System.out.println(String.format("%s ест %d %s", this.character, this.foodAmount, food));
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
