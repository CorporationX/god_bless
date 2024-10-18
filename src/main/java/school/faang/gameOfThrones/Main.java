package school.faang.gameOfThrones;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int THREAD_POOL_SIZE = 10;

  public static void main(String[] args) {
    List<String> roles = new ArrayList<>();
    roles.add("Lord");
    roles.add("knight");
    roles.add("mage");

    House house = new House(roles);

    User DaenerysTargaryen = new User("Daenerys Targaryen");
    User TyrionLannister = new User("Tyrion Lannister");
    User AryaStark = new User("Arya Stark");
    User JonSnow = new User("Jon Snow");
    User CerseiLannister = new User("Cersei Lannister");

    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    executorService.submit(() -> DaenerysTargaryen.joinHouse(house, house.getRoles().get(0)));
    executorService.submit(() -> TyrionLannister.joinHouse(house, house.getRoles().get(1)));
    executorService.submit(() -> AryaStark.joinHouse(house, house.getRoles().get(2)));

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    System.out.println("==================================================================");

    executorService.submit(() -> JonSnow.joinHouse(house, house.getRoles().get(0)));
    executorService.submit(() -> CerseiLannister.joinHouse(house, house.getRoles().get(2)));

    executorService.submit(AryaStark::leaveHouse);
    executorService.submit(DaenerysTargaryen::leaveHouse);

    executorService.shutdown();

    try {
      if(executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.printf("поток %s дождался завершения других потоков\n", Thread.currentThread().getName());
      }else {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
