package faang.school.godbless.feedPeterGriffin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) throws InterruptedException {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        for (String character : characterNames) {
//            executorService.submit(new FoodDeliveryTask(character, new Random().nextInt(50)));
//        }

        Arrays.stream(characterNames)
                .forEach(character -> executorService.submit(new FoodDeliveryTask(character, new Random().nextInt(50))));
        executorService.shutdown();
    }
}
