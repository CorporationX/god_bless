package faang.school.godbless.modul3.griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stevie"};

        Arrays.stream(characterNames)
                .forEach(name -> executor.submit(new FoodDeliveryTask(name, new Random().nextInt(1, 10))));

        executor.shutdown();
    }
}
