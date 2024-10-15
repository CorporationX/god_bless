package school.faang.TomAndJerry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int THREAD_POOL_SIZE = 5;

  private static final int INITIAL_DELAY = 0;
  private static final int PERIOD = 2;

  public static void main(String[] args) {
    List<Room> rooms = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      rooms.add(new Room());
    }

    for (Room room : rooms) {
      for (int i = 0; i < 5; i++) {
        room.PutFood(new Food(String.valueOf(new Random().nextInt(100))));
      }
    }

    House house = new House(rooms);


    try (ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE)) {
      scheduledExecutorService.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS);

      while (!house.allFoodCollected()) {
        Thread.sleep(100);
      }

      scheduledExecutorService.shutdown();

      if (!scheduledExecutorService.awaitTermination(5, TimeUnit.MINUTES)) {
        scheduledExecutorService.shutdownNow();
      } else {
        house.getRooms().forEach(room -> room.getFoods().forEach(System.out::println));
        System.out.println(house.getCollectedFood());
      }
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}
