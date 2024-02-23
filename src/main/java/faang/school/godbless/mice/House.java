package faang.school.godbless.mice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {


    private static Object lock = new Object();
    List<Food> foods = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        Room room1 = new Room( "Bedroom", new ArrayList<>() );
        house.addFood( new Food( "Apple" ), room1 );
        house.addFood( new Food( "Banana" ), room1 );
        house.addRoom( room1 );

        Room room2 = new Room( "Kitchen", new ArrayList<>() );
        house.addFood( new Food( "Carrot" ), room2 );
        house.addFood( new Food( "Tomato" ), room2 );
        house.addRoom( room2 );

        final int THREAD_AMOUNT = 5;

        ScheduledExecutorService executor = Executors.newScheduledThreadPool( THREAD_AMOUNT );

        for (int i = 0; i < 5; i++) {
            executor.schedule( house::collectFood, 1, TimeUnit.SECONDS );
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

    public void addFood(Food food, Room r) {
        List<Food> foodList = r.getFoods();
        if (foodList != null) {
            foodList.add( food );
        }
    }

    public List<Food> collectFood() {
        for (Room r : rooms) {
            synchronized (lock) {
                List<Food> foodInRoom = r.getFoods();
                foods.addAll( foodInRoom );
                foodInRoom.clear();
            }
        }
        System.out.println( "Collected food" + foods );
        return foods;
    }
}
