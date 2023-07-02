package faang.school.godbless.Multithreading.ParallelismAndThread.task02_FeedPeterGriffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    public static int getCharacter(int maxNum) {
        return new Random().nextInt(maxNum);
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " get " + foodAmount + " " + foodType);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            System.out.println(Thread.currentThread().getName() + " Is interrupt");
            Thread.currentThread().interrupt();
        }
        System.out.println("Delivery delivered. " + character + " eating " + foodAmount + " " + foodType);
    }
}
