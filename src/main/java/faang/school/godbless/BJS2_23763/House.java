package faang.school.godbless.BJS2_23763;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        long roomsWithFood = countRoomsWithFood();
        if (roomsWithFood > 1) {
            Room firstRoom = getFirstRoomWithFood();
            Food firstFood = firstRoom.getFood();
            collectedFood.add(firstFood);

            Room secondRoom = getSecondRoomWithFood(firstRoom);
            Food secondFood = secondRoom.getFood();
            collectedFood.add(secondFood);

            System.out.println("Get " + firstFood + " and " + secondFood);

        } else if (roomsWithFood == 1) {
            Room firstRoom = getFirstRoomWithFood();
            Food firstFood = firstRoom.getFood();
            collectedFood.add(firstFood);

            System.out.println("Get " + firstFood);
        }
    }

    private long countRoomsWithFood() {
        return rooms.stream()
                .filter(Room::isFoodHere)
                .count();
    }

    private Room getFirstRoomWithFood() {
        return rooms.stream()
                .filter(Room::isFoodHere)
                .findFirst()
                .orElseThrow();
    }

    private Room getSecondRoomWithFood(Room firstRoom) {
        return rooms.stream()
                .filter(room -> !firstRoom.equals(room))
                .filter(Room::isFoodHere)
                .findFirst()
                .orElseThrow();
    }
}
