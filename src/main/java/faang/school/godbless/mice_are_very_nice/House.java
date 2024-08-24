package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private final List<Food> foodList;
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.foodList = new ArrayList<>();
        this.rooms = rooms;
    }

    public void collectFood() {
        List<Food> tempCollected = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            tempCollected.addAll(room.collectFood());
        }
        foodList.addAll(tempCollected);
        System.out.println("Collected food: " + tempCollected);
    }

    public static void main(String[] args) {
        Food banana = new Food("Banana");
        Food eag = new Food("Eag");
        Food cheese = new Food("Cheese");
        Food bread = new Food("Bread");
        Food butter = new Food("Butter");

        List<Food> foodListFirstRoom = List.of(banana, eag, cheese);
        List<Food> foodListSecondRoom = List.of(bread, butter);



        Room firstRoom = new Room(foodListFirstRoom, "Living room");
        Room secondRoom = new Room(foodListSecondRoom, "Kitchen");

        House house = new House(List.of(firstRoom, secondRoom));

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            scheduled.scheduleAtFixedRate(() -> {
                house.collectFood();
            }, 0, 30, TimeUnit.SECONDS);
        }

        scheduled.shutdown();

    }
}
