package faang.school.godbless.feed.Griffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {

        ExecutorService threads = Executors.newFixedThreadPool(3);

        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.asList(characterNames).stream().forEach(s -> threads.execute(new FoodDeliveryTask(s, new Random().nextInt(50) +1)));

        threads.shutdown();
    }
}
