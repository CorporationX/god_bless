package school.faang.bjs248223.model;

import lombok.Getter;
import lombok.ToString;
import school.faang.bjs248223.service.RoomService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
public class House {
    @Getter
    private final List<Room> rooms;
    @Getter
    private final Set<Food> collectedFood = Collections.synchronizedSet(new HashSet<>());
    private final RoomService roomService;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.roomService = new RoomService(rooms);
    }

    public void collectFood() {
        System.out.println("Log: collectFood is started");
        Room[] selectedRooms = roomService.get2RandomRooms();
        for (Room selectedRoom : selectedRooms) {
            List<Food> foods = selectedRoom.foods();
            foods.clear();
            collectedFood.addAll(foods);
            System.out.println("Log: collectedFood " + foods);
        }
    }
}
