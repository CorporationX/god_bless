package faang.school.godbless;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinFoodDelivery {
    public static void main(String[] args){
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(String character : characterNames){
            executorService.execute(new FoodDeliveryTask(character, new Random().nextInt(100)));
        }

        executorService.shutdown();
    }
}
