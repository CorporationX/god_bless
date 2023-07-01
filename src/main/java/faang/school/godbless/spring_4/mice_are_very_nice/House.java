package faang.school.godbless.spring_4.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Food> COLLECTED_FOOD = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);

        List<Food> foods = List.of(
                new Food("Bacon"), new Food("Beef"), new Food("Chicken"), new Food("Duck"), new Food("Ham"), new Food("Lamb")
        );

        List<Room> rooms = List.of(
                new Room(foods), new Room(foods), new Room(foods), new Room(foods), new Room(foods), new Room(foods)
        );

        List<List<Room>> twoRooms = weDivideIntoTwoRooms(rooms);

        for (List<Room> roomList : twoRooms) {
            pool.schedule(() -> {
                collectFood(roomList);
            }, 5, TimeUnit.SECONDS);
        }

        andStreams(pool);

        System.out.println("The food is collected");

        System.out.println(COLLECTED_FOOD.size());

        COLLECTED_FOOD.forEach(food -> System.out.println(food.getFood()));

        twoRooms.forEach(food -> food.forEach(food1 -> System.out.println(food1.getFoods())));
    }

    private static void andStreams(ScheduledExecutorService pool) throws InterruptedException {
        Thread.sleep(10000);
        pool.shutdown();
        try {
            while (!pool.awaitTermination(20, TimeUnit.SECONDS)) {
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
        int sizeFor = rooms.size() / 2;
        boolean checkSize = false;
        if (rooms.size() % 2 == 1) {
            sizeFor += 1;
            checkSize = true;
        }

        for (int i = 0; i < sizeFor; i++) {
            roomsList.add(new ArrayList<>(rooms.subList(fromIndex, toIndex)));
            if (checkSize & i == sizeFor - 1) {
                toIndex += 1;
            } else {
                toIndex += 2;
            }
            fromIndex += 2;
        }
        return roomsList;
    }

    private static void collectFood(List<Room> rooms) {
        for (Room room : rooms) {
            COLLECTED_FOOD.addAll(room.getFoods());
        }
        // rooms.removeAll(rooms);
    }
}
