package feedPeterGriffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final Random random = new Random();


    @Override
    public void run() {
        FoodType randomFood = getFoodType();
        System.out.println(character + " is getting " + foodAmount + " " + randomFood.toString());
        try {
            Thread.sleep((random.nextInt(5) + 1) * 1000);
            System.out.println(character + " is eating " + foodAmount + " " + randomFood.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
