package miceAreVeryNice_1073;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Food> foods = new ArrayList<>();
    private static final int DELAY_SECONDS = 10;

    public  static void collectFood(Room room) {
        synchronized (foods){foods.addAll(room.getFoods());
        room.getFoods().clear();}
    }

    public static void collectRoom() {
        rooms = List.of(new Room("room1", fillFood()),
                new Room("room2", fillFood()));
    }

    public static List<Food> fillFood() {
        List<Food> foodsRoom = new ArrayList<>();
        Random random = new Random();
        int countFood = random.nextInt(1, 5);
        for (int i = 0; i < countFood; i++) {
            int itemFood = random.nextInt(1, 50);
            foodsRoom.add(new Food("Food_" + itemFood));
        }
        return foodsRoom;
    }

    public static void main(String[] args) throws InterruptedException {

        collectRoom();
        System.out.println(rooms);
        List<Future<?>> futures = new ArrayList<>();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        for (Room room : rooms) {
            Future<?> future = service.schedule(() -> collectFood(room), DELAY_SECONDS, TimeUnit.SECONDS);
            futures.add(future);
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        service.shutdown();
        System.out.println("Вся еда в доме собрана: " + foods);
    }
}