package faang.school.godbless.miceareverynice2949;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class House {
    List<Food> foodInHouse;
    List<Room> rooms;

    public static void main(String[] args) throws InterruptedException {
        House mammyTwoShoesHouse = new House(new ArrayList<>(), Room.initializeRoomList());
        ScheduledExecutorService foodCollector = Executors.newScheduledThreadPool(5);
        printTestInfo(mammyTwoShoesHouse);

        long startTime = System.currentTimeMillis();
        for (Room room : mammyTwoShoesHouse.getRooms()) {
            foodCollector.schedule(() -> mammyTwoShoesHouse.collectFood(room), 30L, TimeUnit.SECONDS);
        }
        foodCollector.shutdown();
        foodCollector.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        long endTime = System.currentTimeMillis();
        System.out.printf("All food is collected in %d seconds %n", (endTime - startTime) / 1000);
        printTestInfo(mammyTwoShoesHouse);
    }

    public void collectFood(Room room) {
        if (!room.getFoodInRoom().isEmpty()) {
            this.getFoodInHouse().addAll(room.getFoodInRoom());
            room.getFoodInRoom().clear();
            System.out.printf("Food in room %d is collected.%n", room.getNumber());
        }
    }

    private static void printTestInfo(House mammyTwoShoesHouse) {
        List<Food> foodList = mammyTwoShoesHouse.getFoodInHouse();
        List<Room> rooms = mammyTwoShoesHouse.getRooms();
        System.out.println("Food collected:");
        for (Food food : foodList) {
            System.out.println(food);
        }
        System.out.println("Food scattered around the house:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
