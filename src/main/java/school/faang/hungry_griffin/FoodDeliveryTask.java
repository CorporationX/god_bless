package school.faang.hungry_griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private static final Random RANDOM = new Random();

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType.name());
        try {
            Thread.sleep(RANDOM.nextInt(4) + 1);
            System.out.println(character + " начал есть " + foodAmount + " " + foodType.name());
        } catch (InterruptedException e) {
            System.out.println(character + " остался голодным");
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }
}
