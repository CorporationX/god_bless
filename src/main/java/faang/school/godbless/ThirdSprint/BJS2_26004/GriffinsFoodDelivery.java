package faang.school.godbless.ThirdSprint.BJS2_26004;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {

    private static String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Arrays.stream(characterNames)
                .forEach(string -> service.execute(new FoodDeliveryTask(string,
                        new Random().nextInt(5))));
        service.shutdown();

    }
}
