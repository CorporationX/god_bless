package school.faang.multithreading.miceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private final List<Room> roomList = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        Room firstRoom = roomList.get(new Random().nextInt(roomList.size()));
        Room secondRoom = roomList.get(new Random().nextInt(roomList.size()));

        if (firstRoom.hasFood()) {
            collectedFood.addAll(firstRoom.getFoodList());
            firstRoom.removeAllFood();
        }
        if (secondRoom.hasFood()) {
            collectedFood.addAll(secondRoom.getFoodList());
            secondRoom.removeAllFood();
        }
    }

    public static void main(String[] args) {
        Food chocolate = new Food("chocolate");
        Food avocado = new Food("avocado");
        Food cherry = new Food("cherry");
        Food cheese = new Food("cheese");
        Food potato = new Food("potato");

        Room room1 = new Room(new ArrayList<>(List.of(potato, chocolate)));
        Room room2 = new Room(new ArrayList<>(List.of(chocolate, potato, cheese)));
        Room room3 = new Room(new ArrayList<>(List.of(avocado, cherry)));
        Room room4 = new Room(new ArrayList<>(List.of(cheese, potato, chocolate)));
        Room room5 = new Room(new ArrayList<>(List.of(cheese, potato, chocolate)));

        House house = new House();
        house.getRoomList().addAll(List.of(room1, room2, room3, room4, room5));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Собираем еду...");
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
                System.out.println("Еда в доме собрана!");
            }
        }, 0, 3, TimeUnit.SECONDS);
    }

    public boolean allFoodCollected() {
        for (Room room : roomList) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}
