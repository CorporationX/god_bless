package faang.school.godbless.feedPeterGriffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit((new FoodDeliveryTask(getCharacterName(),getAmount())));
        executorService.submit((new FoodDeliveryTask(getCharacterName(),getAmount())));
        executorService.submit((new FoodDeliveryTask(getCharacterName(),getAmount())));

        executorService.shutdown();
    }

    private static String getCharacterName() {
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        return characterNames[new Random().nextInt(characterNames.length)];
    }

    private static int getAmount() {
        return new Random().nextInt((100-1 + 1) + 1);
    }
}
