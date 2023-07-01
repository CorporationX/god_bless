package Multithreading.bc2038;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for(String character : characterNames){
            executorService.submit(new FoodDeliveryTask(character, getFoodAmount()));
        }
        executorService.shutdown();
    }

    public static int getFoodAmount(){
        return new Random().nextInt(20) + 5;
    }
}
