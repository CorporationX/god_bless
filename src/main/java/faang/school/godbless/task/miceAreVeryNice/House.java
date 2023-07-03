package faang.school.godbless.task.miceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private final List<Room> rooms;
    private final List<Food> foods;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.foods = new ArrayList<>();
    }

    public void collectFood() {
        int roomCount = 0;
        for (Room room : this.getRooms()) {
            if (roomCount == 2) {
                break;
            }

            if (room.getFoods().isEmpty()) {
                continue;
            }

            this.getFoods().addAll(room.getFoods());
            room.getFoods().clear();

            roomCount++;
        }
    }

    public static void main(String[] args) {
        Food cheese = new Food("Cheese");
        Food meat = new Food("Meat");
        Food cucumber = new Food("Cucumber");
        Food hamburger = new Food("Hamburger");
        Food cheburek = new Food("Cheburek");
        Food fish = new Food("Fish");

        List<Room> rooms = new ArrayList<>(List.of(
                new Room(new ArrayList<>(List.of(cheese, cucumber))),
                new Room(new ArrayList<>(List.of(meat, fish))),
                new Room(new ArrayList<>(List.of(hamburger, cheburek, fish))),
                new Room(new ArrayList<>(List.of(cheese, meat, cucumber))),
                new Room(new ArrayList<>(List.of(cheburek, cucumber)))
        ));

        House house = new House(rooms);

        final int THREAD_COUNT = 5;

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                System.out.println(house.getFoods());
                System.out.println("All food was collected!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
