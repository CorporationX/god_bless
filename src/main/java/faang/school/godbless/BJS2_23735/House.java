package faang.school.godbless.BJS2_23735;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@AllArgsConstructor
@Getter
@Slf4j
public class House {
    private List<Room> rooms;
    private List<Food> food;

    public static void main(String[] args) throws InterruptedException {
        House house = new House(prepareRooms(), new ArrayList<>());
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        IntStream
                .range(0, house.getRooms().size())
                .filter(counter -> counter % 2 == 0)
                .forEach(oddRoomNumber -> service.schedule(() -> {
                    log.info("{} room {}", Thread.currentThread().getName(), oddRoomNumber);
                    house.collectFood(house.getRooms().get(oddRoomNumber));
                    if(house.getRooms().size() > oddRoomNumber + 1){
                        house.collectFood(house.getRooms().get(oddRoomNumber + 1));
                        log.info("{} room {}", Thread.currentThread().getName(), oddRoomNumber + 1);
                    }

                }, 30, TimeUnit.SECONDS));

        service.shutdown();
        service.awaitTermination(50, TimeUnit.SECONDS);
        log.info("Total amount of stolen food: {}", house.food);
    }

    public void collectFood(Room room){
        food.addAll(room.food());
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
