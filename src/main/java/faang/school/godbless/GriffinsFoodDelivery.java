package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.random.RandomGenerator;

public class GriffinsFoodDelivery {

    public static void main(String... args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for(String characterName : characterNames){
            executorService.submit(new FoodDeliveryTask(characterName, RandomGenerator.getDefault().nextInt(99)+1));
        }
        executorService.shutdown();
    }
}
