package mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class House {

    private final static int NUM_ROOMS = 10;
    private final static long DELAY = 30;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> food = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.generateRooms(NUM_ROOMS);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < NUM_ROOMS / 2; i++) {
            Room[] roomsToCollect = {house.getRooms().get(i * 2), house.getRooms().get(i * 2 + 1)};
            executor.schedule(() -> {
                house.collectFood(roomsToCollect[0]);
                house.collectFood(roomsToCollect[1]);
            }, DELAY, TimeUnit.SECONDS);
        }

        executor.shutdown();
        if (executor.awaitTermination(DELAY * house.getRooms().size(), TimeUnit.SECONDS)) {
            System.out.println("Все комнаты убраны!");
        } else {
            System.out.println("Время выполнения программы превышено");
        }
    }

    private void collectFood(Room room) {
        if (room != null) {
            food.addAll(room.getFood());
            room.getFood().clear();
        }
    }

    private Room generateRoom() {
        Random rnd = new Random();
        int foodAmount = rnd.nextInt(1, 10);
        String[] foodName = {"Pizza", "Ice Cream", "Porridge", "Carrot", "Milk", "Steak", "Nachos", "Chips"};
        List<Food> food = new ArrayList<>();

        for (int i = 0; i < foodAmount; ++i) {
            food.add(new Food(foodName[rnd.nextInt(foodName.length)]));
        }
        return new Room(food);
    }

    private void generateRooms(int amount) {
        rooms.clear();
        for (int i = 0; i < amount; ++i) {
            rooms.add(generateRoom());
        }
    }
}
