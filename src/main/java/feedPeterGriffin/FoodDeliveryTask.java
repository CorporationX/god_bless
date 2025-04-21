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
        System.out.printf("%s is getting %d %s\n", character, foodAmount, randomFood.toString());
        try {
            Thread.sleep((random.nextInt(5) + 1) * 1000);
            System.out.printf(" %s is eating %d %s", character, foodAmount, randomFood);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            System.out.printf("%s не смог получить %s из-за прерывания.%n", character, randomFood);
            e.printStackTrace();
        }
    }

    public FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
