package faang.school.godbless.feedPeterGriffin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        List<String> characterList = Arrays.asList(characterNames);
        Collections.shuffle(characterList);
        characterList.toArray(characterNames);
        System.out.println(Arrays.toString(characterNames));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(5) + 1;
            FoodDeliveryTask task = new FoodDeliveryTask(character, foodAmount);
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}
