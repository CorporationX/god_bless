package faang.school.godbless.thread.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    public static void main(String[] args) throws InterruptedException {
        List<Room> rooms = getRooms();
        List<Food> collectedFoods = new ArrayList<>();
        List<List<Room>> roomsCollection = getRoomsCollection(rooms, 2);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < roomsCollection.size(); i++) {
            int finalI = i;
            executorService.schedule(() -> collectFood(roomsCollection.get(finalI), collectedFoods), 30 * finalI, TimeUnit.SECONDS);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Food in house collected");
        collectedFoods.forEach(System.out::println);
        rooms.forEach(r -> System.out.println(r.getFoods()));
    }

    private static List<List<Room>> getRoomsCollection(List<Room> rooms, int size) {
        List<List<Room>> roomsCollection = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i += size) {
            int end = Math.min(rooms.size(), i + size);
            roomsCollection.add(rooms.subList(i, end));
        }
        return roomsCollection;
    }

    private static List<Room> getRooms() {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("Мыло"));
        foods.add(new Food("Хлеб"));
        foods.add(new Food("Свечи"));
        foods.add(new Food("Зерно"));
        foods.add(new Food("Колбаса"));
        foods.add(new Food("Собачий корм"));

        return List.of(
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods)
        );
    }

    private static void collectFood(List<Room> rooms, List<Food> collectedFoods) {
        for (Room room : rooms) {
            collectedFoods.addAll(room.getFoods());
            room.deleteFood();
        }
    }
}
