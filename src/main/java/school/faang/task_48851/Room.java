package school.faang.task_48851;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Room {
  public static Map<String,Integer> countFoodRoom = new HashMap<>();
  private List<Food> listFood;

  private String nameRoom;
  public static final int CREATE_COUNT_FOOD =100;

  public Room() {
    this.nameRoom = "" + new Random().nextInt(0,10);
    createFoodList();
  }

  List<Food> createFoodList() {
    listFood = new ArrayList<>();
    for (int i = 0; i < CREATE_COUNT_FOOD ; i++) {
      listFood.add(new Food("Food" + i));
    }
    countFoodRoom.put(nameRoom,listFood.size());
    return listFood;

  }
  void delFood(Food food) {
    listFood.remove(food);
  }

}
