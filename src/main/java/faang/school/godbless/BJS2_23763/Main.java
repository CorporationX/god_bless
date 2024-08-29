package faang.school.godbless.BJS2_23763;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_AMOUNT = 5;
    private static final long DElAY = 2;

    public static void main(String[] args) {
        House house = new House();
        setupRoomsAndFood(house);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_AMOUNT);

        while (countRoomWithFood(house) > 0) {
            Room roomOne = house.getRooms().stream()
                    .filter(room -> !room.getFoods().isEmpty())
                    .findFirst()
                    .orElseThrow();

            Room roomTwo = house.getRooms().stream()
                    .filter(room -> !room.getFoods().isEmpty())
                    .dropWhile(room -> room.equals(roomOne))
                    .findFirst()
                    .orElseThrow();

            ScheduledFuture<Void> result = executor.schedule(() -> {
                house.collectFood(roomOne, roomTwo);
                return null;
            }, DElAY, TimeUnit.SECONDS);

            try {
                result.get();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread was interrupted");
            } catch (ExecutionException e) {
                throw new RuntimeException("Get result error");
            }
        }

        executor.shutdown();
        System.out.println("All foods collected");
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

    private static int countRoomWithFood(House house) {
        return (int) house.getRooms().stream()
                .filter(room -> !room.getFoods().isEmpty())
                .count();
    }
}
