package BJS2_5670;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stew"};

        Arrays.stream(characterNames)
                .forEach(name -> service.submit(new FoodDeliveryTask(name, new Random().nextInt(1, 51))));

        service.shutdown();
    }
}
