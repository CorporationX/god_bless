package mice_are_very_nice;

import lombok.Data;
import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static final SecureRandom random = new SecureRandom();
    private static final int POOL_SIZE = 5;
    private List<Room> rooms;
    private List<Food> collectedFoods = new ArrayList<>();
    private static final int MIN_COUNT_ROOMS = 2;


    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Collects food from the first and second halves of the house, and
     * removes it from the rooms. If either room is empty, the method returns
     * immediately without doing anything.
     */
    public void collectFood() {
        if (rooms.size() < MIN_COUNT_ROOMS) {
            throw new IllegalArgumentException("The house must have at least 2 rooms");
        }

        Room firstRoom = rooms.get(getRandomNumber(0, rooms.size() / 2 - 1));
        Room secondRoom = rooms.get(getRandomNumber(rooms.size() / 2, rooms.size() - 1));

        if (firstRoom.getFoods().isEmpty() && secondRoom.getFoods().isEmpty()) {
            return;
        }

        collectedFoods.addAll(firstRoom.getFoods());
        collectedFoods.addAll(secondRoom.getFoods());

        firstRoom.setFoods(List.of());
        secondRoom.setFoods(List.of());
    }

    /**
     * Generates a random number in the range [min, max].
     *
     * @param min The lower bound of the range, inclusive.
     * @param max The upper bound of the range, inclusive.
     * @return A random number in the range [min, max].
     */
    private int getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(POOL_SIZE);
        
        House house = new House(
                List.of(
                        new Room(
                                List.of(
                                        new Food("mice"),
                                        new Food("apple"),
                                        new Food("fish")
                                )
                        ),
                        new Room(
                                List.of(
                                        new Food("grapes"),
                                        new Food("banana")
                                )
                        ),
                        new Room(
                                List.of(
                                        new Food("egg"),
                                        new Food("rice"),
                                        new Food("garlic"),
                                        new Food("potato")
                                )
                        ),
                        new Room(
                                List.of(
                                        new Food("cucumber"),
                                        new Food("milk")
                                )
                        ),
                        new Room(
                                List.of(
                                        new Food("juice"),
                                        new Food("bread"),
                                        new Food("chocolate")
                                )
                        ),
                        new Room(
                                List.of(
                                        new Food("water"),
                                        new Food("tea")
                                )
                        )
                )
        );

        for (int i = 0; i < POOL_SIZE; i++) {
            service.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        }

        service.schedule(() -> {
            service.shutdown();
            System.out.println("Еда в доме собрана! Общая еда: " + house.getCollectedFoods());
        }, 1, TimeUnit.MINUTES);
    }
}
