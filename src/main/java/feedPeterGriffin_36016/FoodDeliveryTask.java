package feedPeterGriffin_36016;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private int foodAmount;

    @Override
    public void run() {
        Random random = new Random();
        String typeFood = getFoodType();
        int countSleep = random.nextInt(1000, 5001);
        int lostFood = random.nextInt(foodAmount);
        System.out.println(character + " заказал " + foodAmount + " " + typeFood);
        try {
            Thread.sleep(countSleep);
            System.out.println(character + " ест " + (foodAmount - lostFood) + " " + typeFood);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private String getFoodType(){
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
