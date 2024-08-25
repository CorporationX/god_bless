package faang.school.godbless;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
@RequiredArgsConstructor
public class House {
    private final List<Room> roomList;
    private List<Food> collectedFood = new ArrayList<>();

    public void collectFood(Room room1, Room room2) {
        List<Food> foodFromRooms = new ArrayList<>();
        log.info("collect " + room1.name + " and " + room2.name);
        // Collect food from first room
        synchronized (roomList) {
            foodFromRooms.addAll(roomList.get(roomList.indexOf(room1)).getFoods());
            foodFromRooms.addAll(roomList.get(roomList.indexOf(room2)).getFoods());
            roomList.get(roomList.indexOf(room1)).getFoods().clear();
            roomList.get(roomList.indexOf(room2)).getFoods().clear();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        collectedFood.addAll(foodFromRooms);
        }

        log.info("Collected food: " + foodFromRooms);
    }

    public static void main(String[] args) {
        List<Food> foodRoom1 = List.of(new Food("Apple"), new Food("Banana"));
        List<Food> foodRoom2 = List.of(new Food("Bread"), new Food("Cheese"));
        List<Food> foodRoom3 = List.of(new Food("Milk"), new Food("Eggs"));
        List<Food> foodRoom4 = List.of(new Food("Juice"), new Food("Carrot"));
        List<Food> foodRoom5 = List.of(new Food("Orange"), new Food("Tomato"));
        List<Food> foodRoom6 = List.of(new Food("Pear"), new Food("Watermelon"));
        List<Food> foodRoom7 = List.of(new Food("Chocolate"), new Food("Candy"));
        List<Food> foodRoom8 = List.of(new Food("Pasta"), new Food("Rice"));

        // Создаем комнаты и добавляем в них еду
        Room room1 = new Room("1",new ArrayList<>(foodRoom1));
        Room room2 = new Room("2",new ArrayList<>(foodRoom2));
        Room room3 = new Room("3",new ArrayList<>(foodRoom3));
        Room room4 = new Room("4",new ArrayList<>(foodRoom4));
        Room room5 = new Room("5",new ArrayList<>(foodRoom5));
        Room room6 = new Room("6",new ArrayList<>(foodRoom6));
        Room room7 = new Room("7",new ArrayList<>(foodRoom7));
        Room room8 = new Room("8",new ArrayList<>(foodRoom8));
        // Создаем дом и добавляем в него комнаты
        House house = new House(List.of(room1, room2, room3, room4, room5, room6, room7, room8));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
log.info("staretd");
        for (int i = 0; i < house.roomList.size(); i = i + 2) {
            final int index = i;
            executorService.schedule(() ->
                    house.collectFood(
                            house.roomList.get(index),
                            house.roomList.get(index + 1)
                    ),5,TimeUnit.SECONDS);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All food collected!");

    }

}
