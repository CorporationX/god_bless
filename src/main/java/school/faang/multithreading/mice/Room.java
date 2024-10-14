package school.faang.multithreading.mice;

import java.util.ArrayList;
import java.util.List;

public class Room {

  private String name;
  private List<Food> foodList = new ArrayList<>();

  public Room(String name, List<Food> foodList) {
    this.name = name;
    this.foodList = foodList;
  }

  public void addFood(List<Food> food) {
    foodList.addAll(food);
  }

  public void removeFood() {
    foodList = new ArrayList<>();
  }

}
