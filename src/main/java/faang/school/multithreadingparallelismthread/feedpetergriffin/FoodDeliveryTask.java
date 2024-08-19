package faang.school.multithreadingparallelismthread.feedpetergriffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final String name;
    private final String character;
    private final int foodAmount;

    private static final long TIME_SLEEP_THREAD = 100;


    @Override
    public void run() {
        System.out.println(name + " Получает " + foodAmount + " " + character);
        try {
            Thread.sleep(foodAmount * TIME_SLEEP_THREAD);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " Ест " + foodAmount + " " + character);

    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    public FoodDeliveryTask(String name, int foodAmount) {
        this.name = name;
        this.character = getFoodType();
        this.foodAmount = foodAmount;
    }
}
