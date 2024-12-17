package school.faang.task_48851;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Room {
  private List<Food> listFood;
  private String nameRoom;
  public static final int CREATE_COUNT_FOOD =10000;

  public Room() {
    this.nameRoom = "" + new Random().nextInt(0,10);
    createFoodList();
  }

  List<Food> createFoodList() {
    listFood = new ArrayList<>();
    for (int i = 0; i < CREATE_COUNT_FOOD ; i++) {
      listFood.add(new Food("Food" + i));
    }
    return listFood;

  }
}
