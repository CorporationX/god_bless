package school.faang.multithreading.mice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    List<Food> vegetables = List.of(
        new Food("onion"),
        new Food("potatoes"));
    List<Food> meat = List.of(
        new Food("beef"),
        new Food("pork"));
    List<Food> fruits = List.of(
        new Food("apple"),
        new Food("banana"));
    List<Room> rooms = List.of(
        new Room("storage", vegetables),
        new Room("kitchen", meat),
        new Room("living room", fruits));
    House house = new House(rooms);

    int corePoolSize = 5;
    ExecutorService service = Executors.newScheduledThreadPool(corePoolSize);

  }

}
