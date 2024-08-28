package faang.school.godbless;

import faang.school.godbless.Notification.Notification;

import java.util.*;

import java.time.LocalDateTime;
import java.util.*;

import faang.school.godbless.House.Food;
import faang.school.godbless.House.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public Application(List<Room>rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }

    public synchronized void collectFood() {
        if (rooms.size() >= 2) {
            Room room1 = rooms.remove(0);
            Room room2 = rooms.remove(0);

            collectedFood.addAll(room1.collectFood());
            collectedFood.addAll(room2.collectFood());
        }
    }

    public boolean isFoodCollected() {
        return rooms.isEmpty();
    }

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Кухня", List.of(new Food("Яблоко"), new Food("Банан"))));
        rooms.add(new Room("Гостиная", List.of(new Food("Печенье"), new Food("Шоколад"))));
        rooms.add(new Room("Спальня", List.of(new Food("Чипсы"), new Food("Вода"))));
        rooms.add(new Room("Подвал", List.of(new Food("Сыр"), new Food("Колбаса"))));
        rooms.add(new Room("Чердак", List.of(new Food("Орехи"), new Food("Мед"))));
        rooms.add(new Room("Гараж", List.of(new Food("Сухофрукты"), new Food("Сок"))));

        Application house = new Application(rooms);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> {
                house.collectFood();
                if (house.isFoodCollected()) {
                    System.out.println("All food in house!");
                    executor.shutdown();
                }
            }, i * 30, TimeUnit.SECONDS);
        }
    }
}
