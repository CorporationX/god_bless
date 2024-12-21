package school.faang.task_48851;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class House {

  public static int SELECT_COUNT_ROOM = 2;

  public static Map<String,Integer> leftoverFoodRoom = new HashMap<>();
  private List<Room> rooms;
  private String houseName;
  private int roomsNumber;

  public House(String houseName, int roomsNumber) {
    this.houseName = houseName;
    this.roomsNumber = roomsNumber;

    createRooms(roomsNumber);
  }

  private void createRooms(int countRoom) {
    List<Room> rooms = new ArrayList<>();
    for (int i = 0; i < countRoom; i++) {
      rooms.add(new Room());
    }
    this.rooms = rooms;
  }


  public void collectFood(List<Food> foodList, House house) {
    List<Food> newFoodList = new ArrayList<>();

    List<Room> newRooms = new ArrayList<>(house.rooms);

    for (int i = 0; i < SELECT_COUNT_ROOM; i++) {
      try {
        int random = getRandomRooms(newRooms);

          Food tempfood = house.getRooms().get(random).getListFood().get(0);
          house.getRooms().get(random).delFood(tempfood);
          foodList.add(tempfood);
          System.out.println("Добавили " + tempfood.toString());


      } finally {

      }
    }
  }

  private int getRandomRooms(List<Room> listRoom) {
    int a = new Random().nextInt(listRoom.size());
    listRoom.remove(a);
    return a;
  }
}
