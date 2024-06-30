package BJS_11830;

import java.util.ArrayList;
import java.util.List;

public class Room {
    String name;
    List<Food> foodInRoomList = new ArrayList<>();

    Room(String name, ArrayList<Food> foodInRoomList) {
        this.name = name;
        this.foodInRoomList = foodInRoomList;
    }

    public List<Food> getFoodInRoomList() {
        return foodInRoomList;
    }
}
