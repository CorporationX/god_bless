package faang.school.godbless;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static List<Room> rooms;
    private static List<Food> collectedFoodList;
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

    public House(List<Room> rooms) {
        House.rooms = rooms;
        collectedFoodList = new ArrayList<>();
    }

    public static void main(String[] args) {
        House house = new House(initialise());


        for (int i = 0; i < rooms.size(); i += 2) {
            Room room1 = rooms.get(i);
            Room room2 = rooms.get(i + 1);
            int delay = i * 15;
            executor.schedule(() -> house.collectFood(room1, room2), delay, TimeUnit.SECONDS);
        }
        shutdown();

        System.out.println("Еда в доме собрана!");
        System.out.println(collectedFoodList);
    }

    private void collectFood(Room room1, Room room2) {
        collectedFoodList.addAll(room1.getFoodList());
        collectedFoodList.addAll(room2.getFoodList());
        room1.getFoodList().clear();
        room2.getFoodList().clear();
    }

    public static List<Room> initialise() {
        List<Food> firstRoom = List.of(new Food("Cheese"), new Food("Meat"));
        List<Food> secondRoom = List.of(new Food("Eggs"), new Food("Bread"));
        List<Food> thirdRoom = List.of(new Food("Coca-Cola"), new Food("Water"));
        List<Food> fourthRoom = List.of(new Food("bottle of wine"), new Food("sandwich"));

        Room first = new Room("First", firstRoom);
        Room second = new Room("Second", secondRoom);
        Room third = new Room("Third", thirdRoom);
        Room fourth = new Room("FourthRoom", fourthRoom);

        return List.of(first, second, third, fourth);
    }

    private static void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Did not have time");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
