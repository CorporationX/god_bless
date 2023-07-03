package faang.school.godbless.Sprint4.Task_2_Griffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Steve"};

        for(int i = 0; i < characterNames.length; i++) {
            executor.submit(new FoodDeliveryTask(characterNames[i], 1 + (int) (Math.random() * 5)));
        }
        executor.shutdown();
    }
}
