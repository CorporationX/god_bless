
package faang.school.godbless.FeedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private ConcurrentHashMap<String, String> taskStatus;

    public FoodDeliveryTask(String character, int foodAmount, ConcurrentHashMap<String, String> taskStatus) {
        this.character = character;
        this.foodAmount = foodAmount;
        this.taskStatus = taskStatus;
    }

    @Override
    public void run() {
        Random random = new Random();
        String foodType = getFoodType();
        StringBuilder message = new StringBuilder(String.format("%s is receiving %d %s%n", character, foodAmount, foodType));
        taskStatus.put(character, "In Progress");
        for (int i = 0; i < foodAmount; i++) {
            try {
                int sleepTime = 1000 + random.nextInt(4000);
                Thread.sleep(sleepTime);
                message.append(character).append(" is eating ").append(foodType).append("\n");
            } catch (InterruptedException e) {
                System.out.println(character + " was interrupted while receiving " + foodType);
                Thread.currentThread().interrupt();
                taskStatus.put(character, "Interrupted");
                return;
            }
        }
        System.out.print(message.toString());
        taskStatus.put(character, "Completed");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}