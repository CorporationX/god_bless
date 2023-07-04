package faang.school.godbless.spring_4.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Food> COLLECTED_FOOD = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int sizePool = 3;

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(sizePool);

        List<Food> foods = List.of(
                new Food("Bacon"), new Food("Beef"), new Food("Chicken"), new Food("Duck"), new Food("Ham"), new Food("Lamb")
        );

        List<Room> rooms = List.of(
                new Room(foods), new Room(foods), new Room(foods), new Room(foods), new Room(foods), new Room(foods)
        );

        List<List<Room>> twoRooms = weDivideIntoTwoRooms(rooms);
        int i = 0;
        for (List<Room> roomList : twoRooms) {
            ++i;
            Runnable task = () -> {
                collectFood(roomList);
            };
            pool.schedule(task, 5L * i, TimeUnit.SECONDS);
        }

        finish(pool);

        System.out.println("The food is collected");

        System.out.println(COLLECTED_FOOD.size());
    }

    private static void finish(ScheduledExecutorService pool) throws InterruptedException {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(20, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
    }

    private static List<List<Room>> weDivideIntoTwoRooms(List<Room> rooms) {

        List<List<Room>> roomsList = new ArrayList<>();

        int fromIndex = 0;
        int toIndex = 2;

        int sizeFor = (rooms.size() + 1) / 2;

        for (int i = 0; i < sizeFor; i++) {
            roomsList.add(new ArrayList<>(rooms.subList(fromIndex, toIndex)));
            fromIndex += 2;
            toIndex += 2;
        }

        return roomsList;
    }

    private static void collectFood(List<Room> rooms) {
        for (Room room : rooms) {
            COLLECTED_FOOD.addAll(room.getFoods());
        }
        rooms.removeAll(rooms);
    }
}
