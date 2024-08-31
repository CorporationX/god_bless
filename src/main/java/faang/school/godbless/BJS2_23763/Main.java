package faang.school.godbless.BJS2_23763;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_AMOUNT = 1;
    private static final long DELAY = 2;

    public static void main(String[] args) {
        House house = new House();
        setupRoomsAndFood(house);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_AMOUNT);

        List<List<Room>> roomPairs = createRoomsPair(house);
        IntStream.range(0, roomPairs.size())
                .forEach(i -> {
                    Room roomOne = roomPairs.get(i).get(0);
                    Room roomTwo = roomPairs.get(i).get(1);
                    executor.schedule(() -> house.collectFood(roomOne, roomTwo), i * DELAY, TimeUnit.SECONDS);
                });
        executor.shutdown();

        try {
            if (!executor.awaitTermination(DELAY * roomPairs.size(), TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Await error");
        }

        System.out.println("All food collected");
    }


    private static void setupRoomsAndFood(House house) {
        Room roomOne = new Room();
        roomOne.addFoods(Arrays.asList(
                new Food("Bread"),
                new Food("Egg")
        ));

        Room roomTwo = new Room();
        roomTwo.addFoods(Arrays.asList(
                new Food("Chicken breast"),
                new Food("Cheese")
        ));

        Room roomThree = new Room();
        roomThree.addFoods(Arrays.asList(
                new Food("Cucumber"),
                new Food("Potato"),
                new Food("Yogurt")
        ));

        Room roomFour = new Room();
        roomFour.addFoods(Arrays.asList(
                new Food("Rise"),
                new Food("Apple"),
                new Food("Butter")
        ));

        house.getRooms().addAll(Arrays.asList(
                roomOne,
                roomTwo,
                roomThree,
                roomFour
        ));
    }

    private static List<List<Room>> createRoomsPair(House house) {
        List<Room> rooms = house.getRooms().stream()
                .flatMap(room -> room.getFoods().stream().map(food -> room))
                .toList();

        return IntStream.iterate(0, i -> i < rooms.size(), i -> i + 2)
                .mapToObj(i -> Arrays.asList(rooms.get(i), rooms.get(i + 1)))
                .toList();
    }
}
