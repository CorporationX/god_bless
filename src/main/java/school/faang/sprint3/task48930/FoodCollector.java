package school.faang.sprint3.task48930;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.sprint3.task48930.model.Room;

import java.util.ArrayList;

@Slf4j
@Getter
@RequiredArgsConstructor
public class FoodCollector implements Runnable {

    private final String name;
    private final House house;

    @Override
    public void run() {
        Room room1 = Room.getRandomRoom(house.getRooms(), new Room("", new ArrayList<>()));
        Room room2 = Room.getRandomRoom(house.getRooms(), room1);
        house.collectFoodInRooms(name, room1, room2);
        house.refreshIsEmpty();
    }
}
