package faang.school.godbless.sprint2.griffins;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {

  private String character;
  private int foodAmount;

  @SneakyThrows
  @Override
  public void run() {
    String foodType = getFoodType();
    log.info(String.format("%s ожидает доставку %s %s", character, foodAmount, foodType));
    Thread.sleep(foodAmount * 1000L);
    log.info(String.format("%s получил %s %s", character, foodAmount, foodType));
  }

  private String getFoodType() {
    String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    return foodTypes[new Random().nextInt(foodTypes.length)];
  }
}
