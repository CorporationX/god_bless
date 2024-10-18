package school.faang.tomandjerry;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
public class House {
    public static final int CORE_POOL_SIZE = 5;
    private List<Food> collectedFood = new ArrayList<>();
    private List<Room> rooms;
    private boolean allFoodCollected = false;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static List<Room> initialization() {
        List<Room> initializedRooms = new ArrayList<>();
        String[] foods = {"tomato paste", "broccoli", "chili pepper", "cherry tomatoes"
                , "peanut butter", "meat", "peaches", "cheese", "cupcakes", "lemon", "bananas"};
        Random random = new Random();
        int randomCountOfRooms = random.nextInt(1, 11);
        for (int i = 0; i < randomCountOfRooms; i++) {
            Room room = new Room();
            int randomCountOfFoods = random.nextInt(1, 11);

            for (int j = 0; j < randomCountOfFoods; j++) {
                String someFood = foods[random.nextInt(foods.length)];
                room.addFood(new Food(someFood));
            }
            initializedRooms.add(room);
        }
        return initializedRooms;
    }

    public void  assigningTasksToThreads(ScheduledExecutorService scheduler, House house) {
        for (int i = 0; i < house.getRooms().size(); i++) {
            scheduler.scheduleAtFixedRate(() -> {
                house.collectFood();
            }, 0, 1, TimeUnit.SECONDS);
        }
        while (!allFoodCollected()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Caught exception: ", e);
            }
        }
        scheduler.shutdown();
    }

    public void collectFood() {
        if (rooms == null || rooms.isEmpty()) {
            allFoodCollected = true;
        }
        Random random = new Random();
        Room firstRoom = rooms.get(random.nextInt(rooms.size()));
        Room secondRoom = rooms.get(random.nextInt(rooms.size()));
        if (firstRoom.hasFood() && secondRoom.hasFood()) {
            collectedFood.addAll(firstRoom.getFoodInRoom());
            collectedFood.addAll(secondRoom.getFoodInRoom());
        }
        firstRoom.removeAllFood(firstRoom.getFoodInRoom());
        secondRoom.removeAllFood(secondRoom.getFoodInRoom());
        this.getRooms().remove(firstRoom);
        this.getRooms().remove(secondRoom);
    }

    public boolean allFoodCollected() {
        List<Room> roomsForCheck = new ArrayList<>(rooms);
        for (Room room : roomsForCheck) {
            if (room != null && room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}
