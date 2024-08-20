package faang.school.godbless.BJS2_23735;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class House {
    private List<Room> rooms;
    private List<Food> food;

    public static void main(String[] args) {
        House house = new House(prepareRooms(), new ArrayList<>());
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        house
                .getRooms()
                .forEach(room -> service.schedule(() -> house.collectFood(room), 30, TimeUnit.SECONDS));

        service.shutdown();
    }

    public void collectFood(Room room){
        food.addAll(room.food());
    }

    public static void fillHouseWithFood(House house){

    }

    private static List<Room> prepareRooms(){
        String[] roomNames = {"kitchen", "bedroom", "livingroom", "bathroom", "toilet"};
        List<Room> rooms = new ArrayList<>();

        Arrays.stream(roomNames).forEach(currentRoom -> rooms.add(generateRoom(currentRoom)));

        return rooms;
    }

    private static Room generateRoom(String roomName){
        List<Food> food = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            food.add(new Food(roomName + i));
        }
        return new Room(food);
    }
}
