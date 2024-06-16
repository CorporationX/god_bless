package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    List<Food> foodInRoom;

    public static List<Room> getListRoom() {
        return Arrays.asList(
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood()),
                new Room(Food.getListFood())
        );
    }
}
