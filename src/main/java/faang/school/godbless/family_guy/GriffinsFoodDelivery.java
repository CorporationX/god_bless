package faang.school.godbless.family_guy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Arrays.stream(characterNames).forEach(name -> executor.execute(new FoodDeliveryTask(name, new Random().nextInt(100))));
        executor.shutdown();
    }
}
