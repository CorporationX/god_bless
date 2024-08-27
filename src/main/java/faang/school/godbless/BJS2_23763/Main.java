package faang.school.godbless.BJS2_23763;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_AMOUNT = 5;
    private static final long DELAY = 30;

    public static void main(String[] args) {
        House house = new House();
        setupRoomsAndFood(house);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_AMOUNT);
        IntStream.range(0, THREAD_AMOUNT)
                .forEach(i -> executor.schedule(house::collectFood, DELAY * i, TimeUnit.SECONDS));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(THREAD_AMOUNT * DELAY, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Await termination error");
        }
        System.out.println("Food collected");
    }

    private static void setupRoomsAndFood(House house) {
        Room roomOne = new Room();
        roomOne.addFoods(Arrays.asList(
                new Food("Bread"),
                new Food("Egg"),
                new Food("Milk")
        ));

        Room roomTwo = new Room();
        roomTwo.addFoods(Arrays.asList(
                new Food("Chicken breast"),
                new Food("Cheese")
        ));

        Room roomThree = new Room();
        roomThree.addFoods(Arrays.asList(
                new Food("Cucumber"),
                new Food("Potato")
        ));

        Room roomFour = new Room();
        roomFour.addFoods(Arrays.asList(
                new Food("Rise"),
                new Food("Apple"),
                new Food("Banana")
        ));

        Room roomFive = new Room();
        roomFive.addFoods(Arrays.asList(
                new Food("Carrot"),
                new Food("Yogurt"),
                new Food("Butter")
        ));

        house.getRooms().addAll(Arrays.asList(
                roomOne,
                roomTwo,
                roomThree,
                roomFour,
                roomFive
        ));
    }
}
