package faang.school.godbless.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms;
    private final List<Food> collectFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectFood = new ArrayList<>();
    }

    public void collectFood(){
        for (Room room: rooms){
            collectFood.addAll(room.getRoomsFood());
            room.clearFood();
        }
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "House{" +
                "collectFood=" + collectFood +
                '}';
    }

    public static void main(String[] args) {
        House house = new House();

        Room room1 = new Room();
        room1.addFood(new Food("food1"));
        room1.addFood(new Food("food2"));
        house.addRoom(room1);

        Room room2 = new Room();
        room2.addFood(new Food("food3"));
        room2.addFood(new Food("food4"));
        house.addRoom(room2);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i<5; i++){
            executor.schedule(() -> {
                house.collectFood();
                System.out.println("Food collected");
            }, 30, TimeUnit.SECONDS);
        }

        executor.shutdown();


        try {
            executor.awaitTermination(200, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All food was collected");


    }
}
