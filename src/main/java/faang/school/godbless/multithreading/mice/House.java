package faang.school.godbless.multithreading.mice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
@Slf4j
public class House {

    private final List<Room> rooms;
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        synchronized (rooms) {
            for (Room room : rooms) {
                collectedFood.addAll(room.foods());
                room.foods().clear();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var threadPool = Executors.newScheduledThreadPool(5);
        var house = new House(getRooms());
        for (int i = 0; i < house.rooms.size(); i++) {
            threadPool.schedule(house::collectFood, 5, TimeUnit.SECONDS);
        }
        threadPool.shutdown();
        var isCollected = threadPool.awaitTermination(30, TimeUnit.SECONDS);
        if (isCollected) {
            log.info("All food collected.");
            house.getCollectedFood().forEach(System.out::println);
        } else {
            log.info("Time's out!");
        }
    }

    private static List<Room> getRooms() {
        return List.of(
                new Room(List.of(new Food("pizza"), new Food("burger"))),
                new Room(List.of(new Food("pie"), new Food("sushi"))),
                new Room(List.of(new Food("soup"), new Food("donut"))
                )
        );
    }

}
