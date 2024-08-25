package faang.school.godbless.TomAndJary;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class House {
    private List<Room> rooms;
    private final List<Food> foods = new ArrayList<>();

    public static void main(String[] args) {
        List<Food> foodRoom1 = java.util.List.of(new Food("Apple"), new Food("Banana"));
        List<Food> foodRoom2 = List.of(new Food("Bread"), new Food("Cheese"));
        List<Food> foodRoom3 = List.of(new Food("Milk"), new Food("Eggs"));
        List<Food> foodRoom4 = List.of(new Food("Juice"), new Food("Carrot"));

        // Создаем комнаты и добавляем в них еду
        Room room1 = new Room("room1", new ArrayList<>(foodRoom1));
        Room room2 = new Room("room2", new ArrayList<>(foodRoom2));
        Room room3 = new Room("room3", new ArrayList<>(foodRoom3));
        Room room4 = new Room("room4", new ArrayList<>(foodRoom4));
        // Создаем дом и добавляем в него комнаты
        House house = new House(List.of(room1, room2, room3, room4));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < house.rooms.size(); i = i + 2) {
            int finalI = i;
            executorService.schedule(() -> house.collectFood(List.of(house.rooms.get(finalI), house.rooms.get(finalI + 1))), 2, TimeUnit.SECONDS);
        }
    }

    public void collectFood(List<Room> rooms) {
        rooms.forEach(room -> {
            synchronized (room) {
                log.info("added fod in foods from " + room);
                foods.addAll(room.getFoods());
                room.getFoods().clear();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
