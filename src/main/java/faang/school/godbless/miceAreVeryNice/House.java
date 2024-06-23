package faang.school.godbless.miceAreVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class House {
    private static final int DELAY_THREAD_POOL = 30;
    private static final int THREAD_POOL_SIZE = 5;
    private static final int AWAIT_ExecutorService = 90;
    private static final int NUMBER_ROOM_ON_THREAD = 2;

    private static List<Room> rooms = new ArrayList<>();
    private static List<Food> collectFoods = new ArrayList<>();

    public static void main(String[] args) {
        initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            int indexRoom = i + NUMBER_ROOM_ON_THREAD;
            executor.schedule(() -> collectFood(indexRoom), DELAY_THREAD_POOL, TimeUnit.SECONDS);
        }
        executor.shutdown();

        try {
            executor.awaitTermination(AWAIT_ExecutorService, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Food is collected: " + collectFoods.size());
    }

    private static void collectFood(int index) {
        List<Room> twoRooms = rooms.subList(index, index + NUMBER_ROOM_ON_THREAD);

        for (Room room : twoRooms) {
            collectFoods.addAll(room.getFoods());
            room.getFoods().clear();
        }
    }

    private static House initialize() {
        List<Food> foodRoom1 = List.of(
                new Food("Burger"),
                new Food("Steak"),
                new Food("Pizza"),
                new Food("Salad")
        );

        List<Food> foodRoom2 = List.of(
                new Food("Pasta"),
                new Food("Taco"),
                new Food("Soup"),
                new Food("Cake")
        );

        List<Food> foodRoom3 = List.of(
                new Food("Apple"),
                new Food("Banana")
        );

        List<Food> foodRoom4 = List.of(
                new Food("Cookies"),
                new Food("Milk"),
                new Food("Tea")
        );


        Room room1 = new Room(foodRoom1);
        Room room2 = new Room(foodRoom2);
        Room room3 = new Room(foodRoom3);
        Room room4 = new Room(foodRoom4);

        Room room5 = new Room(foodRoom4);
        Room room6 = new Room(foodRoom3);
        Room room7 = new Room(foodRoom2);
        Room room8 = new Room(foodRoom1);


        return new House(List.of(room1, room2, room3, room4,
                room5, room6, room7, room8));
    }

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }
}
