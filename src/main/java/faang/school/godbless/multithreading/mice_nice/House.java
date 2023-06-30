package faang.school.godbless.multithreading.mice_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Room> rooms;
    private List<String> allFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.allFood = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Kitchen", List.of("bread", "banana", "chease", "milk")));
        rooms.add(new Room("Bedroom", List.of("pizza", "rice", "maize")));
        rooms.add(new Room("Bathroom", List.of("water", "candies")));
        rooms.add(new Room("Living room", List.of("cookies", "cake")));
        rooms.add(new Room("Bathroom", List.of("bread", "banana", "chease", "milk")));
        rooms.add(new Room("Bedroom", List.of("pizza", "rice", "maize")));
        rooms.add(new Room("Kitchen", List.of("water", "candies")));
        rooms.add(new Room("Bedroom", List.of("cookies", "cake")));
        House house = new House(rooms);

        for (int i = 0; i < house.rooms.size(); i+=2) {
            Room room1 = house.rooms.get(i);
            Room room2 = house.rooms.get(i+1);
            int delay = i*2;
            service.schedule(() -> house.collectFood(room1, room2), delay, TimeUnit.SECONDS);
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
                System.out.println("Did not have time");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All food collected "+ house.allFood.size());
    }

    private void collectFood(Room room1, Room room2) {
        allFood.addAll(room1.getFood());
        allFood.addAll(room2.getFood());
        System.out.printf("Added %s meals from %s, (%s)\n",
                room1.getFood().size(), room1.getName(), Thread.currentThread().getName());
        System.out.printf("Added %s meals from %s, (%s)\n",
                room2.getFood().size(), room2.getName(), Thread.currentThread().getName());
        room1.getFood().clear();
        room2.getFood().clear();
    }
}
