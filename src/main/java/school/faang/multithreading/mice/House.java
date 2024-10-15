package school.faang.multithreading.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class House {

  private List<Room> rooms = new ArrayList<>();
  private List<Food> collectedFood = new ArrayList<>();

  public void collectFood() throws InterruptedException {
    Random random = new Random();
    int roomsCount = 2;
    List<Room> randomRooms = new ArrayList<>();
    for (int i = 0; i < roomsCount; i++) {
      randomRooms.add(rooms.get(random.nextInt(rooms.size())));
    }

    System.out.println(Thread.currentThread().getName() + " looking for food in");

    for (Room room : randomRooms) {
      System.out.println(room + " room");
      if (room.hasFood()) {
        pickupFood(room);
      } else {
        System.out.println("no food :( here");
      }
    }

  }

  private void pickupFood(Room room) {
    Food food = room.getFoodList().get(0);
    collectedFood.add(food);
    room.removeFood(0);
    System.out.println("picked up: " + food);
  }

  public boolean isHouseEmpty() {
    return rooms.stream().noneMatch(Room::hasFood);
  }

  public void addRoom(Room room) {
    rooms.add(room);
  }

}
