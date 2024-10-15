package school.faang.TomAndJerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
  private final List<Room> rooms;
  private final List<Food> collectedFood = new ArrayList<>();

  House(List<Room> rooms) {
    this.rooms = rooms;
  }

  public void collectFood() {
    Random random = new Random();
    List<Integer> indexesRooms = new ArrayList<>();

    if (rooms.size() > 2) {
      indexesRooms.add(random.nextInt(rooms.size()));
      int secondRoomIndex;

      do {
        secondRoomIndex = random.nextInt(rooms.size());
      } while (secondRoomIndex == indexesRooms.get(0));

      indexesRooms.add(secondRoomIndex);
    } else {
      for (int i = 0; i < rooms.size(); i++) {
        indexesRooms.add(i);
      }
    }

    indexesRooms.forEach(i -> {
      collectedFood.addAll(rooms.get(i).getFoods());
      rooms.get(i).clearRoom();
    });
  }

  public boolean allFoodCollected() {
    return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
  }
}
