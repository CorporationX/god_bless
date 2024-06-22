package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private List<Food> foodInRoom;

    public static List<Room> getListRoom() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            rooms.add(new Room(Food.getListFood()));
        }
        return rooms;
    }
}
