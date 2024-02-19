package faang.school.godbless.griff;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService foodDeliveryTask = Executors.newFixedThreadPool( 3 );
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            foodDeliveryTask.submit( new FoodDeliveryTask( character, new Random().nextInt( 15 ) ) );
        }

        foodDeliveryTask.shutdown();
    }
}
