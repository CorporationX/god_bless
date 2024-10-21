package school.faang.Mnogopotochka.ParallelismThread.BJS2_35982;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Random random = new Random();

        for(String characters : characterNames){
            executorService.submit(new FoodDeliveryTask(characters, random.nextInt(1,50)));
        }
        executorService.shutdown();
    }
}
