package school.faang.sprint_3.task_43553;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
    private static final int RANDOM_SLEEP_TIME = 5000;
    private static final int BASE_SLEEP_TIME = 1000;

    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            Thread.sleep(new Random().nextInt(RANDOM_SLEEP_TIME) + BASE_SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodType + " из-за прерывания.");
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
