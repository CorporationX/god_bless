package faang.school.godbless.sprint2.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Evgenii Malkov
 */
public class GriffinsFoodDelivery {
  public static void main(String[] args) {
    int threadsCount = 3;
    Random random = new Random();
    String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
    for (int i = 0; i < 10; i++) {
      executorService.submit(new FoodDeliveryTask(
          characterNames[new Random().nextInt(characterNames.length)], random.nextInt(1, 30)));
    }
    executorService.shutdown();
  }
}
