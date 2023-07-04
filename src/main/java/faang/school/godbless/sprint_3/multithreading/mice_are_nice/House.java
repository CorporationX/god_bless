package faang.school.godbless.sprint_3.multithreading.mice_are_nice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@Getter
@Setter
public class House {
    private List<Room> rooms;
    private List<Food> allFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood(List<Room> rooms) {
        rooms.forEach(room -> {
            allFood.addAll(room.getFoodList());
            room.getFoodList().clear();
        });
    }

    public static void main(String[] args) {
        House house = new House(initialize());

        try (ScheduledExecutorService service = Executors.newScheduledThreadPool(5)) {
            int batchSize = 2;
            for (int i = 0; i < house.rooms.size(); i += batchSize) {
                int endIndex = Math.min(i + batchSize, house.rooms.size());
                List<Room> sublist = house.rooms.subList(i, endIndex);
                service.scheduleAtFixedRate(() -> house.collectFood(sublist), 0, 30, TimeUnit.SECONDS);
            }
            System.out.println("Еда собрана!");
        }
    }

    private static List<Room> initialize() {
        List<Food> firstRoom = List.of(new Food("banana"), new Food("potato"));
        List<Food> secondRoom = List.of(new Food("sandwich"), new Food("coca-cola"), new Food("bottle"));
        List<Food> thirdRoom = List.of(new Food("eggs"));
        List<Food> fourthRoom = List.of(new Food("bottle of water"), new Food("sandwich"));
        List<Food> fifthRoom = List.of(new Food("snack"), new Food("sandwich"), new Food("chips"));
        Room basement = new Room("Basement", fourthRoom);
        Room kitchen = new Room("Kitchen", firstRoom);
        Room hallRoom = new Room("HallRoom", secondRoom);
        Room bedroom = new Room("Bedroom", thirdRoom);
        Room wardrobe = new Room("Wardroberoom", fifthRoom);
        return List.of(basement, kitchen, hallRoom, bedroom, wardrobe);
    }
}