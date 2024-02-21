package faang.school.godbless.mice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {

    private static List<Food> foods = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        Room room1 = new Room( "Bedroom", new ArrayList<>() );
        room1.addFood( new Food( "Apple" ) );
        room1.addFood( new Food( "Banana" ) );
        house.addRoom( room1 );

        Room room2 = new Room( "Kitchen", new ArrayList<>() );
        room2.addFood( new Food( "Carrot" ) );
        room2.addFood( new Food( "Tomato" ) );
        house.addRoom( room2 );

        house.addFood( new Food( "Apple" ) );
        house.addFood( new Food( "Banana" ) );
        house.addFood( new Food( "Carrot" ) );
        house.addFood( new Food( "Tomato" ) );

        ScheduledExecutorService executor = Executors.newScheduledThreadPool( 5 );

        for (int i = 0; i < 5; i++) {
            executor.scheduleAtFixedRate( House::collectFood, 0, 1, TimeUnit.SECONDS );
        }

        try {
            if (!executor.awaitTermination( 1, TimeUnit.MINUTES )) {
                System.out.println( "Failed to complete all tasks within 1 minute" );
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println( "Waiting for task completion interrupted:" + e.getMessage() );
        }

        executor.shutdown();
    }

    public void addRoom(Room room) {
        rooms.add( room );
    }

    public void addFood(Food food) {
        foods.add( food );
    }

    public static synchronized List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>();
        for (Room r : rooms) {
            synchronized (r) {
                List<Food> foodInRoom = r.getFoods();
                collectedFood.addAll( foodInRoom );
                foodInRoom.clear();
            }
        }
        System.out.println( "Collected food" + collectedFood );
        return collectedFood;
    }
}
