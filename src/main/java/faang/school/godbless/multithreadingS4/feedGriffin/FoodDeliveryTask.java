package faang.school.godbless.multithreadingS4.feedGriffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s gets %d %s\n", character, foodAmount, food);
        try {
            Thread.sleep(foodAmount * 100L);
        } catch (InterruptedException e){
            e.getStackTrace();
        }
        System.out.printf("\t%s ate %d %s\n", character, foodAmount, food);
    }

    private static String getFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }
}
