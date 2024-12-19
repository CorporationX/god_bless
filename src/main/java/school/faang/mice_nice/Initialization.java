package school.faang.mice_nice;

import java.util.List;
import java.util.stream.IntStream;

public class Initialization {

    public House createHouse() {
        List<Room> rooms = IntStream.range(0, DataSet.AMOUNT_OF_ROOMS)
                .mapToObj(number -> new Room(101 + number))
                .peek(Room::addFood)
                .toList();
        return new House(rooms);
    }
}
