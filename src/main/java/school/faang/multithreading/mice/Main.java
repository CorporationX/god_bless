package school.faang.multithreading.mice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final int CORE_POOL_SIZE = 5;

  public static void main(String[] args) {
    House house = new House();
    Room kitchen = new Room("kitchen");
    Room storage = new Room("storage");
    Room living = new Room("living");
    house.addRoom(kitchen);
    house.addRoom(storage);
    house.addRoom(living);
    List<String> fruits = List.of("apple", "banana", "orange", "grape");
    living.addFoodPack(fruits);
    List<String> vegetables = List.of("onion", "potatoes", "carrot", "cucumber", "tomatoes");
    kitchen.addFoodPack(vegetables);
    List<String> meat = List.of("beef", "pork", "fish", "chicken");
    storage.addFoodPack(meat);

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

    Runnable collector = () -> {
      try {
        if (house.isHouseEmpty()) {
          System.out.println("*****");
          System.out.println(house.getCollectedFood());
          System.out.println("*****");
          executor.shutdown();
          System.out.println("All food is collected");
        } else {
          System.out.println();
          house.collectFood();
        }

      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };
    executor.scheduleAtFixedRate(collector, 0, 30, TimeUnit.SECONDS);

  }

}
