package school.faang.task_48851;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

  public static void main(String[] args) {

    List<Food> collectionFood = new ArrayList<>();

    House house = new House("myHome", 3);


    house.collectFood(collectionFood, house);


    ExecutorService executor = Executors.newScheduledThreadPool(5);


    for (int i = 0; i < 10000; i++) {
      executor.submit(() -> {
          house.collectFood(collectionFood, house);
      });
    }
    System.out.println();
  }
}
