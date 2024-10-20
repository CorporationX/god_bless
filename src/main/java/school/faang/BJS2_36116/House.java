package school.faang.BJS2_36116;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
    private static final int THREAD_POOL_SIZE = 5;

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initialize() {
        Room room1 = new Room();
        room1.addFood(new Food("Сыр"));
        room1.addFood(new Food("Хлеб"));

        Room room2 = new Room();
        room2.addFood(new Food("Колбаса"));
        room2.addFood(new Food("Яблоко"));

        Room room3 = new Room();
        room3.addFood(new Food("Печенье"));

        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Недостаточно комнат для сбора еды" );
            return;
        }

        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;
        do {
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while (room1 == room2);

        synchronized (room1) {
            synchronized (room2) {
                if (room1.hasFood() || room2.hasFood()) {
                    List<Food> collectedFromRoom1 = room1.hasFood() ? room1.removeAllFood() : Collections.emptyList();
                    List<Food> collectedFromRoom2 = room2.hasFood() ? room2.removeAllFood() : Collections.emptyList();

                    collectedFood.addAll(collectedFromRoom1);
                    collectedFood.addAll(collectedFromRoom2);

                    System.out.println("Собрана еда из комнат:");
                    collectedFromRoom1.forEach(food -> System.out.println("- " + food.getName() + " из комнаты 1"));
                    collectedFromRoom2.forEach(food -> System.out.println("- " + food.getName() + " из комнаты 2"));
                } else {
                    System.out.println("Обе комнаты пустые. Сбор не состоялся.");
                }
            }
        }

        if (allFoodCollected()) {
            System.out.println("Еда в доме собрана!");
        }
    }

        public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executor.shutdown();
                System.out.println("Все еда собрана!");
            }
        }, 0, 30, TimeUnit.SECONDS);
    }
}
