package school.faang.TomAndJerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
  private final List<Food> foods = new ArrayList<>();

  public void PutFood(Food food) {
    foods.add(food);
  }

  public void clearRoom() {
    foods.clear();
  }
}
