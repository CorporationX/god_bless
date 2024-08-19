package faang.school.godbless.sprint3.grifin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    public static final int TASKS = 3;
    public static final int MAX_AMOUNT = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(TASKS);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            int foodAmount = new Random().nextInt(MAX_AMOUNT) + 1;
            executor.submit(new FoodDeliveryTask(characterName, foodAmount));
        }
        executor.shutdown();
    }



}
