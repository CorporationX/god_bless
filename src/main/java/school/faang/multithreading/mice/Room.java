package school.faang.multithreading.mice;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Room {

  private final String name;
  private final List<Food> foodList = new ArrayList<>();

  public Room(String name) {
    this.name = name;
  }

  public boolean hasFood() {
    return !foodList.isEmpty();
  }

  public void addFoodPack(List<String> food) {
    foodList.addAll(food.stream().map(Food::new).toList());
  }

  public void removeFood(int index) {
    foodList.remove(index);
  }

  @Override
  public String toString() {
    return name;
  }
}
