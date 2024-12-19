package school.faang.mice_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = IntStream.range(0, DataSet.AMOUNT_OF_ROOMS)
                .mapToObj(number -> new Room(101 + number))
                .peek(Room::addFood)
                .toList();
        rooms.forEach(room -> System.out.println(room.getFoods() + " " + room.getNumber()));
        House house = new House(rooms);

    }
}
