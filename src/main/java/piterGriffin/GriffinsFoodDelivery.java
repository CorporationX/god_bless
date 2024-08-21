package piterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService execute = Executors.newFixedThreadPool(3);
        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterNames[i], 50);
            execute.submit(foodDeliveryTask);
        }
        execute.shutdown();
    }
}
