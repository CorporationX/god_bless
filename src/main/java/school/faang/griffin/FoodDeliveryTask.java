package school.faang.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.printf("%s получает %d %s%n", character, foodAmount, formatFoodName(foodType, foodAmount));
        try {
            Thread.sleep((random.nextInt(5) + 1) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("%s ест %d %s%n", character, foodAmount, formatFoodName(foodType, foodAmount));
    }

    private String formatFoodName(FoodType type, int amount) {
        if (type == FoodType.CHICKEN_WINGS) {
            return "куриных крылышек";
        }
        if (type == FoodType.PIZZA) {
            return "пицц";
        }
        if (type == FoodType.BURGER) {
            return "бургеров";
        }
        if (type == FoodType.TACO) {
            return "тако";
        }
        return type.name().toLowerCase();
    }
}
