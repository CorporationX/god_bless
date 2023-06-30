package faang.school.godbless.mice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int CORE_POOL_SIZE = 5;
  public static void main(String[] args) {
    House house = new House();

    Room badRoom = new Room();
    badRoom.addFood(new Food("Eggs"));
    badRoom.addFood(new Food("Banana"));

    Room kitchen = new Room();
    kitchen.addFood(new Food("Bread"));
    kitchen.addFood(new Food("Spaghetti"));
    kitchen.addFood(new Food("Oranges"));

    Room bigRoom = new Room();
    bigRoom.addFood(new Food("Ice cream"));
    bigRoom.addFood(new Food("Apples"));
    bigRoom.addFood(new Food("Watermelon"));

    house.addRoom(badRoom);
    house.addRoom(kitchen);
    house.addRoom(bigRoom);


    ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

    for (int i = 0; i < CORE_POOL_SIZE; i++) {
      executor.schedule(house::collectFood, i * 30, TimeUnit.MILLISECONDS);
    }

    executor.shutdown();

    try {
      executor.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    List<Food> collectedFood = house.getCollectedFoods();

    for (Food food : collectedFood) {
      System.out.println("Collected food: " + food.getName());
    }
  }
}
