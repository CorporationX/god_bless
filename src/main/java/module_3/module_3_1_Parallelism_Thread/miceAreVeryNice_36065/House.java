package module_3.module_3_1_Parallelism_Thread.miceAreVeryNice_36065;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter
public class House {
    private final List<Food> collectedFoods = new ArrayList<>();
    private final List<Room> rooms;
    private final Random random = new Random();
    boolean isEmptyAllRooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        Room roomFirst = rooms.get(random.nextInt(0, rooms.size() / 2));
        Room roomSecond = rooms.get(random.nextInt(rooms.size() / 2, rooms.size()));

        isEmptyAllRooms = rooms.stream().allMatch(r -> r.getFoods().isEmpty());
        if (!isEmptyAllRooms) {
            boolean isEmptyRoomFirst = roomFirst.getFoods().isEmpty();
            boolean isEmptyRoomSecond = roomSecond.getFoods().isEmpty();
            if (isEmptyRoomFirst && isEmptyRoomSecond) {
                return;
            }
            if (!isEmptyRoomFirst) {
                collectedFoods.addAll(roomFirst.getFoods());
                roomFirst.setFoods(List.of());
                System.out.println(roomFirst.getName() + " пусто");
            }
            if (!isEmptyRoomSecond) {
                collectedFoods.addAll(roomSecond.getFoods());
                roomSecond.setFoods(List.of());
                System.out.println(roomSecond.getName() + " пусто");
            }
        }
    }
}
