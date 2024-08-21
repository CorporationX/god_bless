
package faang.school.godbless.FeedPeterGriffin;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        Random random = new Random();
        String foodType = getFoodType();
        StringBuilder message = new StringBuilder(character + " is receiving " + foodAmount + " " + foodType + "\n");
        for (int i = 0; i < foodAmount; i++) {
            try {
                int sleepTime = 1000 + random.nextInt(4000);
                Thread.sleep(sleepTime);
                message.append(character).append(" is eating ").append(foodType).append("\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(message.toString());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}