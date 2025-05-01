package school.faang.griffins;

import java.util.Random;

enum FoodType {
    PIZZA, BURGER, TACO, SUSHI, SALAD
}

class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType.toString().toLowerCase() + "(ов).");

        try {
            int delay = 1000 * (1 + random.nextInt(5));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Доставка была прервана: " + e.getMessage());
        }

        System.out.println(character + " ест " + foodAmount + " " + foodType.toString().toLowerCase() + "(ов).");
    }
}
