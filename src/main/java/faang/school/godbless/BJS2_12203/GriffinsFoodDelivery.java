package faang.school.godbless.BJS2_12203;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] character = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
         for (String newCharacters : character){
             int foodAmount = new Random().nextInt(1,100);
             FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(newCharacters , foodAmount);
             executorService.submit(foodDeliveryTask);
         }
         executorService.shutdown();
    }
}
