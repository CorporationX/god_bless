package faang.school.godbless.mice;

import java.util.ArrayList;
import java.util.List;

public class House {
  private List<Food> collectedFoods = new ArrayList<>();
  private List<Room> rooms = new ArrayList<>();

  public void collectFood() {
    int collectedRoomCount = 0;

    for (Room room : rooms) {
      if (collectedRoomCount == 2) break;
      List<Food> availableFood = room.getAvailableFood();
      if (availableFood.isEmpty()) continue;

      collectedFoods.addAll(availableFood);
      room.removeFood();

      collectedRoomCount++;
    }
  }

  public void addRoom(Room room) {
    rooms.add(room);
  }

  public List<Food> getCollectedFoods() {
    return collectedFoods;
  }
}
