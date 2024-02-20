package faang.school.godbless.petergriffin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        Arrays.stream(characterNames).forEach((character)-> executors.submit(new FoodDeliveryTask(character,new Random().nextInt(10000))));
        executors.shutdown();
    }
}
