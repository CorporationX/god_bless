package school.faang.mices;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    @Getter
    private final List<Room> initialRoomsList;
    @Getter
    private final List<Food> collectedFood;
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.initialRoomsList = rooms;
        this.rooms = initialRoomsList;
        this.collectedFood = new ArrayList<>();
    }

    public void collectFood() {
        List<Room> peekedRoom;

        synchronized (initialRoomsList) {
            if (isAllRoomsEmpty()) {
                return;
            }
            peekedRoom = randomRoomIndexes().stream()
                    .map(rooms::get)
                    .toList();
        }

        List<Food> pickedFood = new ArrayList<>();
        peekedRoom.stream()
                .filter(Room::isFoodInTheRoom)
                .forEach(room -> pickedFood.add(room.peekFood()));

        synchronized (collectedFood) {
            collectedFood.addAll(pickedFood);
        }

        synchronized (initialRoomsList) {
            this.rooms = rooms.stream().filter(Room::isFoodInTheRoom).toList();
            log.info("{}", rooms);
        }
    }

    private List<Integer> randomRoomIndexes() {
        SecureRandom randomized = new SecureRandom();
        int firstRoomIndex = randomized.nextInt(0, rooms.size());
        int secondRoomIndex = randomized.nextInt(0, rooms.size());
        return firstRoomIndex == secondRoomIndex ? List.of(firstRoomIndex) : List.of(firstRoomIndex, secondRoomIndex);
    }

    public boolean isAllRoomsEmpty() {
        synchronized (initialRoomsList) {
            return rooms.stream().noneMatch(Room::isFoodInTheRoom);
        }
    }
}