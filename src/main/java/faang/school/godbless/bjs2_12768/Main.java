package faang.school.godbless.bjs2_12768;

import static faang.school.godbless.bjs2_12768.Utils.getRandomString;
import static faang.school.godbless.bjs2_12768.Utils.getRandomValueFromList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {

  private static final int POOL_SIZE = 5;
  private static final long TIME_OUT = 30;
  private static final int USER_LIMIT = 150;

  public static void main(String[] args) {

    List<House> houses = List.of(
        new House("Дом Старков", new ArrayList<>(List.of("Повар", "Стражник", "Служанка"))),
        new House("Дом Ланнистеров", new ArrayList<>(List.of("Конница", "Пехота", "Лучник")))
    );

    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    Stream.generate(() -> new User(getRandomString(), getRandomValueFromList(houses)))
        .limit(USER_LIMIT)
        .forEach(user -> executorService.execute(user::playRole));

    executorService.shutdown();

    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

}
