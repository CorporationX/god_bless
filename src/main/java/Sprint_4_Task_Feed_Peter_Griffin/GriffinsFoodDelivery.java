package Sprint_4_Task_Feed_Peter_Griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < characterNames.length; i++) {
            executorService.submit(new FoodDeliveryTask(characterNames[i], new Random().nextInt(50)+1));
        }

//        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
//        String[] characterNames1 = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
//
//        for (int i = 0; i < characterNames.length; i++) {
//            executorService1.submit(new FoodDeliveryTask(characterNames1[i], new Random().nextInt(5000)+1));
//        }
//        executorService1.shutdown();
        executorService.shutdown();
    }
}
