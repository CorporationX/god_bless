package school.faang.multithreading.mice;

import java.util.ArrayList;
import java.util.List;

public class House {

  private List<Room> rooms = new ArrayList<>();
  private List<Food> collectedFood = new ArrayList<>();

  public House(List<Room> rooms) {
    this.rooms = rooms;
  }

  public void collectFood() {

  }

}
