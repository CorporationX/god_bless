package faang.school.godbless.BJS2_23735;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

        for (int roomNumber = 0; roomNumber < house.getRooms().size(); roomNumber += 2) {
            int finalRoomNumber = roomNumber;
            service.schedule(() -> {
                log.info("{} room {}", Thread.currentThread().getName(), finalRoomNumber);
                house.collectFood(house.getRooms().get(finalRoomNumber));
                if(house.getRooms().size() > finalRoomNumber + 1){
                    house.collectFood(house.getRooms().get(finalRoomNumber + 1));
                    log.info("{} room {}", Thread.currentThread().getName(), finalRoomNumber + 1);
                }
            },5 + roomNumber, TimeUnit.SECONDS);

        }

        service.shutdown();
        service.awaitTermination(50, TimeUnit.SECONDS);
        log.info("Total amount of stolen food: {}", house.food);
    }

    public void collectFood(Room room){
        food.addAll(room.food());
    }

    private static List<Room> prepareRooms(){
        List<String> roomNames = List.of("kitchen", "bedroom", "livingroom", "bathroom", "toilet");
        List<Room> rooms = new ArrayList<>();

        roomNames.forEach(currentRoom -> rooms.add(generateRoom(currentRoom)));

        return rooms;
    }

    private static Room generateRoom(String roomName){
        List<Food> food = new ArrayList<>();
        List<String> foods = List.of("Apple", "Pizza", "Pineapple", "Hot dog", "Beer", "Chips", "Porridge", "Bread", "Snack", "Coke");
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            food.add(new Food(foods.get(random.nextInt(foods.size()))));
        }
        return new Room(food);
    }
}
