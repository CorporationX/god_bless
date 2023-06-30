package faang.school.godbless.mice;

import java.util.ArrayList;
import java.util.List;

public class Room {
  private List<Food> availableFoods = new ArrayList<>();

  public List<Food> getAvailableFood() {
    return availableFoods;
  }

  public void addFood(Food food) {
    availableFoods.add(food);
  }

  public void removeFood() {
    availableFoods = new ArrayList<>();
  }
}
