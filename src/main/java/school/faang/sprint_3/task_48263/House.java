package school.faang.sprint_3.task_48263;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Slf4j
public class House {
    @NonNull
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        Random random = new Random();
        collectedFood.addAll(collectFoodFromRoom(random.nextInt(rooms.size())));
        collectedFood.addAll(collectFoodFromRoom(random.nextInt(rooms.size())));
    }

    public boolean isAllFoodCollected() {
        return rooms.stream()
                .allMatch(Room::isAllFoodCollected);
    }

    public void addRoom(@NonNull Room room) {
        rooms.add(room);
    }

    public void removeRoom(@NonNull Room room) {
        rooms.remove(room);
    }

    public List<Room> getRooms() {
        return List.copyOf(rooms);
    }

    private List<Food> collectFoodFromRoom(int roomIndex) {
        Room room = rooms.get(roomIndex);
        List<Food> foodCollectedFromRoom = room.collectAllFood();
        log.info("Collecting food from room {} by thread {}. Collected {} food",
                room,
                Thread.currentThread().getName(),
                foodCollectedFromRoom.size());
        return foodCollectedFromRoom;
    }
}
