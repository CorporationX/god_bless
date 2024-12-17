package school.faang.sprint_3.task_43553;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
    @Override
    public void run() {
        String foodType = getFoodType();
        try {
            System.out.println(character + " получает " + foodAmount + " " + foodType);
            Thread.sleep(new Random().nextInt(5000) + 1000);
            System.out.println(character + " ест " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodType + " из-за прерывания.");
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
