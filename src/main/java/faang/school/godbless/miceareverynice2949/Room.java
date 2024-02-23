package faang.school.godbless.miceareverynice2949;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Room {
    int number;
    List<Food> foodInRoom;

    public Room(int number, List<Food> foodInRoom) {
        this.number = number;
        this.foodInRoom = foodInRoom;
    }

    public static List<Room> initializeRoomList() {
        return new ArrayList<>(List.of(
                new Room(1, Food.initializeFoodList()),
                new Room(2, Food.initializeFoodList()),
                new Room(3, Food.initializeFoodList()),
                new Room(4, Food.initializeFoodList()),
                new Room(5, Food.initializeFoodList()),
                new Room(6, Food.initializeFoodList())
        ));
    }
}
